package ru.geekbrains.graduatework.dao;

import jdk.jfr.ContentType;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

public class ContentTypeDAO extends AbstractEntityDAO{

    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public ContentTypeDAO() {
        super(ContentType.class);
    }

    @Override
    void update() {

    }
}
