# cab-booking-console-app-JPA

# 🚖 Cab Booking Console App - JPA + Hibernate + PostgreSQL

This is a **menu-driven Java console application** for booking cabs, built using **Hibernate (JPA)** for ORM and **PostgreSQL** as the database. It follows layered architecture with separate DAO, Entity, and App modules.

---

## 📌 Key Features

- 🔹 Add a new cab
- 🔹 Update cab details
- 🔹 Delete a cab
- 🔹 Register a new customer
- 🔹 Book a cab
- 🔹 View bookings
- 🔹 Fetch cab history by customer ID
- 🔹 View all cabs and all bookings

---

## 🧩 Technologies Used

| Technology      | Description                        |
|-----------------|------------------------------------|
| Java            | Programming language               |
| Hibernate (JPA) | ORM Framework                      |
| PostgreSQL      | Relational Database                |
| Maven           | Build tool & dependency manager    |
| JDBC            | Database connectivity layer        |

---

## 📁 Folder Structure

<img src="projectStructure">

### 🧾 Prerequisites

- Java 17 or above
- Maven
- PostgreSQL (Ensure it's running)



1. **Configure the DB:**:
<?xml version="1.0" encoding="UTF-8" ?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence
                                 https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">

  <persistence-unit name="Cab_Booking">

	<class>entity.Booking</class>
    <class>entity.Driver</class>
    <class>entity.Customer</class>

    <properties>
      <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
      <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/mydb"/>
      <property name="jakarta.persistence.jdbc.user" value="postgres"/>
      <property name="jakarta.persistence.jdbc.password" value="root123"/>

       <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
       <property name="jakarta.persistence.schema-generation.database.action" value="update"/>
      <property name="hibernate.show_sql" value="true"/>
            
       </properties>
  </persistence-unit>

</persistence>


🧪 Sample Menu Output
<img src ="https://github.com/SUSHANT7019/cab-booking-console-app-JPA/blob/main/output_1.png">
<img src ="https://github.com/SUSHANT7019/cab-booking-console-app-JPA/blob/main/output_2.png">


🙋‍♂️ Author
Sushant Thadge
📫 GitHub: @SUSHANT7019

