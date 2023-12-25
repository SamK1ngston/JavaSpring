package com.example.hw8_2.entity;

import javax.persistence.*;

/**
 * Сущность, представляющая сотрудника в базе данных.
 */
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * Идентификатор сотрудника.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Имя сотрудника.
     */
    @Column(name = "name")
    //@Size(min = 2, message = "name must be 2 or more symbols long")
    private String name;

    /**
     * Фамилия сотрудника.
     */
    @Column(name = "surname")
    //@NotBlank
    private String surname;

    /**
     * Департамент, к которому принадлежит сотрудник.
     */
    @Column(name = "department")
    private String department;

    /**
     * Зарплата сотрудника.
     */
    @Column(name = "salary")
    //@Min(200)
    //@Max(2000)
    private int salary;

    /**
     * Конструктор по умолчанию.
     */
    public Employee() {
    }

    /**
     * Получает идентификатор сотрудника.
     *
     * @return Идентификатор сотрудника.
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор сотрудника.
     *
     * @param id Новый идентификатор сотрудника.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получает имя сотрудника.
     *
     * @return Имя сотрудника.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя сотрудника.
     *
     * @param name Новое имя сотрудника.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает фамилию сотрудника.
     *
     * @return Фамилия сотрудника.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Устанавливает фамилию сотрудника.
     *
     * @param surname Новая фамилия сотрудника.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Получает департамент, к которому принадлежит сотрудник.
     *
     * @return Департамент сотрудника.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Устанавливает департамент, к которому принадлежит сотрудник.
     *
     * @param department Новый департамент сотрудника.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Получает зарплату сотрудника.
     *
     * @return Зарплата сотрудника.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Устанавливает зарплату сотрудника.
     *
     * @param salary Новая зарплата сотрудника.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Возвращает строковое представление объекта сотрудника.
     *
     * @return Строковое представление объекта сотрудника.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}