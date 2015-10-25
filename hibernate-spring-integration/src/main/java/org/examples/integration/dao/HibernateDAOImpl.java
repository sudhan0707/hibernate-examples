package org.examples.integration.dao;

import java.io.Serializable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HibernateDAOImpl<T extends Serializable> extends AbstractHibernateDAO{

}
