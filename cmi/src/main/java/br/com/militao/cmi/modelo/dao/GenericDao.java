/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.militao.cmi.modelo.dao;

import java.util.List;

/**
 *
 * @author Adriano
 */
public interface GenericDao {

	boolean delete(Object obj);

	boolean update(Object obj);

	boolean insert(Object obj);

	List<Object> getList();
}
