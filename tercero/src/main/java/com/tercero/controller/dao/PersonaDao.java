package com.tercero.controller.dao;

import com.google.gson.Gson;
import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Persona;

@SuppressWarnings({ "unchecked", "ConvertToTryWithResources", "rawtypes" })

public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona;
    private LinkedList<Persona> listAll;
    Gson g = new Gson();

    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (this.persona == null) {
            this.persona = new Persona();
        }
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize() + 1;
        getPersona().setId(id);
        this.persist(this.persona);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {
        listAll = listAll();
        this.merge(this.persona, this.persona.getId());
        return true;
    }

    public Boolean delete() throws Exception {
        if (listAll == null) {
            listAll = getListAll();
        }
        this.delete(persona.getId());
        return true;
    }

    public LinkedList order_apellido(Integer type_order) {
        LinkedList listita = listAll();
        if (!listAll().isEmpty()) {
            Persona[] lista = (Persona[]) listita.toArray();
            listita.reset();
            switch (type_order) {
                case 1:
                    for (int i = 1; i < lista.length; i++) {
                        Persona aux = lista[i];
                        int j = i - 1;
                        while (j >= 0 && lista[j].getApellido().compareTo(aux.getApellido()) > 0) {
                            lista[j + 1] = lista[j--];
                        }
                        lista[j + 1] = aux;
                    }
                    break;

                default:
                    for (int i = 1; i < lista.length; i++) {
                        Persona aux = lista[i];
                        int j = i - 1;
                        while (j >= 0 && lista[j].getApellido().compareTo(aux.getApellido()) < 0) {
                            lista[j + 1] = lista[j--];
                        }
                        lista[j + 1] = aux;
                    }
                    break;
            }
            listita.toList(lista);
        }
        return listita;
    }

    public LinkedList<Persona> mergeOrderDni() {
        LinkedList<Persona> listita = listAll();
        if (!listita.isEmpty()) {
            Persona[] lista = (Persona[]) listita.toArray();
            listita.reset();

            mergeSort(lista, 0, lista.length - 1);

            listita.toList(lista);
        }
        return listita;
    }

    private void mergeSort(Persona[] lista, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(lista, left, middle);
            mergeSort(lista, middle + 1, right);

            merge(lista, left, middle, right);
        }
    }

    private void merge(Persona[] lista, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Persona[] leftArray = new Persona[n1];
        Persona[] rightArray = new Persona[n2];

        System.arraycopy(lista, left, leftArray, 0, n1);
        System.arraycopy(lista, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].getDni().compareTo(rightArray[j].getDni()) <= 0) {
                lista[k] = leftArray[i];
                i++;
            } else {
                lista[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            lista[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            lista[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public LinkedList<Persona> orderList() {
        return this.mergeOrderDni();
    }

    /*
     * private LinkedList orderDni(Integer type_order) {
     * LinkedList listita = listAll();
     * if (!listAll().isEmpty()) {
     * Persona[] lista = (Persona[]) listita.toArray();
     * listita.reset();
     * switch (type_order) {
     * case 1:
     * for (int i = 1; i < lista.length; i++) {
     * Persona aux = lista[i];
     * int j = i - 1;
     * while (j >= 0 && lista[j].getDni().compareTo(aux.getDni()) > 0) {
     * lista[j + 1] = lista[j--];
     * }
     * lista[j + 1] = aux;
     * }
     * break;
     * 
     * default:
     * for (int i = 1; i < lista.length; i++) {
     * Persona aux = lista[i];
     * int j = i - 1;
     * while (j >= 0 && lista[j].getDni().compareTo(aux.getDni()) < 0) {
     * lista[j + 1] = lista[j--];
     * }
     * lista[j + 1] = aux;
     * }
     * break;
     * }
     * listita.toList(lista);
     * }
     * return listita;
     * }
     */

    public Persona getPersonaByDni(String dni) throws Exception {
        LinkedList<Persona> listita = mergeOrderDni();
        Persona[] lista = (Persona[]) listita.toArray();
        listita.reset();

        int inicio = 0;
        int ultimo = lista.length - 1;

        while (inicio <= ultimo) {
            int medio = inicio + (ultimo - inicio) / 2;
            int compareResult = lista[medio].getDni().compareTo(dni);
            if (compareResult == 0) {
                return lista[medio];
            } else if (compareResult > 0) {
                ultimo = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        throw new Exception("Persona con DNI " + dni + " no encontrada.");
    }

    public String toJson() throws Exception {
        return g.toJson(this.persona);
    }

    public Persona getPersonaByIndex(Integer index) throws Exception {
        return get(index);
    }

    public String getPersonaJsonByIndex(Integer index) throws Exception {
        return g.toJson(get(index));
    }

}
