package com.mavenproyect.database;

import java.util.List;


public interface DAO<T> {

    /**
     * Obtiene un elemento por el ID recibido.
     *
     * @param id    Id del elemento a buscar.
     * @return T    tipo con el ID enviado como argumento.
     */
    public T seleccionarUno(int id);

    /**
     * Obtiene todos los elementos de un tipo dado.
     *
     * @return List<T> lista a devolver.
     */
    public List<T> seleccionarTodos();

    /**
     * Añade un elemento al recurso.
     *
     * @param elemento  recurso a añadir.
     * @return boolean  True si se añado correctamente,
     *                  False caso contrario.
     */
    public boolean insertar(T elemento);

    /**
     * Actualiza los datos de un elemento en el recurso.
     *
     * @param elemento  recurso a modificar.
     * @return boolean  True si se añado correctamente,
     *                  False caso contrario.
     */
    public boolean actualizar(T elemento);

    /**
     * Elimina los datos de un elemento en el recurso.
     *
     * @param id        id del orador a eliminar
     * @return boolean  True si se elimino correctamente,
     *                  False caso contrario.
     */
    public boolean eliminar(int id);

}
