package ru.project.config;

import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
//import org.hibernate.engine.SessionImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.AbstractPostInsertGenerator;
import org.hibernate.id.IdentifierGeneratorHelper;
import org.hibernate.id.PostInsertIdentityPersister;
import org.hibernate.id.insert.AbstractReturningDelegate;
import org.hibernate.id.insert.IdentifierGeneratingInsert;
import org.hibernate.id.insert.InsertGeneratedIdentifierDelegate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO: get rid of this class, because Hibernate 5 has support of simple identity strategy for Oracle 12
 * org.hibernate.dialect.identity.Oracle12cIdentityColumnSupport
 */
public class TriggerAssignedIdentityGenerator extends AbstractPostInsertGenerator {

    @Override
    public InsertGeneratedIdentifierDelegate getInsertGeneratedIdentifierDelegate(PostInsertIdentityPersister persister, Dialect dialect, boolean isGetGeneratedKeysEnabled) throws HibernateException {
        return new Delegate(persister, dialect);
    }

    public static class Delegate extends AbstractReturningDelegate {

        private Dialect dialect;
        private String[] keyColumns;

        public Delegate(PostInsertIdentityPersister persister, Dialect dialect) {
            super(persister);
            this.dialect = dialect;
            this.keyColumns = getPersister().getRootTableKeyColumnNames();
            if (keyColumns.length > 1) {
                throw new HibernateException("trigger assigned identity generator cannot be used with multi-column keys");
            }
        }

        @Override
        public IdentifierGeneratingInsert prepareIdentifierGeneratingInsert() {
            return new IdentifierGeneratingInsert(dialect);
//            return new SequenceIdentityGenerator.NoCommentsInsert(dialect);
        }

        @Override
        protected PreparedStatement prepare(String insertSQL, SessionImplementor session) throws SQLException {
            return session.connection().prepareStatement(insertSQL, keyColumns);
        }

        @Override
        protected Serializable executeAndExtract(PreparedStatement insert, SessionImplementor session) throws SQLException {
            insert.executeUpdate();
            try (ResultSet generatedKeys = insert.getGeneratedKeys()) {
                return IdentifierGeneratorHelper.getGeneratedIdentity(generatedKeys, keyColumns[0], getPersister().getIdentifierType(), dialect);
            }
        }
    }
}