package imc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClasificareIMCTest
{
    // -- Clase de echivalenta, Valori de frontiera

    // invalid
    @Test void imcNegativ()
    {
        assertEquals("invalid", ClasificareIMC.clasifica(-1));
    }
    @Test void imcZero()
    {
        assertEquals("invalid", ClasificareIMC.clasifica(0));
    }
    @Test void imcPreaMare()
    {
        assertEquals("invalid", ClasificareIMC.clasifica(100.1));
    }
    @Test void imcNaN()
    {
        assertEquals("invalid", ClasificareIMC.clasifica(Double.NaN));
    }
    @Test void imcInfinitPozitiv()
    {
        assertEquals("invalid", ClasificareIMC.clasifica(Double.POSITIVE_INFINITY));
    }

    // subponderal
    @Test void subponderalMargine()
    {
        assertEquals("subponderal", ClasificareIMC.clasifica(18.4));
    }
    @Test void subponderalMic()
    {
        assertEquals("subponderal", ClasificareIMC.clasifica(10));
    }

    // normal
    @Test void normalInferior()
    {
        assertEquals("normal", ClasificareIMC.clasifica(18.5));
    }
    @Test void normalSuperior()
    {
        assertEquals("normal", ClasificareIMC.clasifica(24.9));
    }

    // supraponderal
    @Test void supraponderalInferior()
    {
        assertEquals("supraponderal", ClasificareIMC.clasifica(25.0));
    }
    @Test void supraponderalSuperior()
    {
        assertEquals("supraponderal", ClasificareIMC.clasifica(29.9));
    }

    // obez
    @Test void obezInferior()
    {
        assertEquals("obez", ClasificareIMC.clasifica(30.0));
    }
    @Test void obezSuperior()
    {
        assertEquals("obez", ClasificareIMC.clasifica(39.9));
    }

    // obez morbid
    @Test void morbidInferior()
    {
        assertEquals("obez morbid", ClasificareIMC.clasifica(40.0));
    }
    @Test void morbidCrescut()
    {
        assertEquals("obez morbid", ClasificareIMC.clasifica(90));
    }

    // -- Ucidere mutanti

    // '< 25' |-> '<= 25'
    @Test void ucideMutantMargineNormal()
    {
        assertEquals("supraponderal", ClasificareIMC.clasifica(25.0));
    }

    // '< 40' |-> "<= 40'
    @Test void ucideMutantMargineObez()
    {
        assertEquals("obez morbid", ClasificareIMC.clasifica(40.0));
    }

    // returneaza "obez morbid" |-> returneaza "alt text"
    @Test void ucideMutantReturnareMorbid()
    {
        assertEquals("obez morbid", ClasificareIMC.clasifica(75));
    }
}