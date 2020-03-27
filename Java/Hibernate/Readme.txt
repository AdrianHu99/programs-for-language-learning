Learned how to build this from following posts: 
http://blog.csdn.net/yuebinghaoyuan/article/details/7299619
https://danielniko.wordpress.com/2012/12/03/simple-crud-using-java-hibernate-and-mysql/
http://www.javawebtutor.com/articles/hibernate/hibernate_crud_example.html


1. Create a database in mysql
2. Install hibernate in java plus the sql-java connector
3. Create entity class(getter and setter)
4. Create Hibernate Configuration file(hibernate.cfg.xml)
5. Create Hibernate Utility Class(HibernateUtil.java)
6. Implement CRUD(Create, Read, Update, Delete) on main class

Update on 4/13/2016:

Right now it is done. The problem I found is that it would successfully run the first time, but after that, it will have duplicate data if I run the second time. 

The next steps would be:

1. Don't allow program add duplicate data with same primary keys;
2. Add Spring framework and maybe Maven.
