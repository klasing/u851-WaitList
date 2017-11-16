package com.example.waitlist;

import android.provider.BaseColumns;

import com.example.waitlist.data.WaitlistContract;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ContractClassUnitTest {
    @org.testng.annotations.Test
    public void inner_class_exists() throws Exception {
        Class[] innerClasses = WaitlistContract.class.getDeclaredClasses();
        assertEquals("There should be 1 Inner class inside the contract class", 1, innerClasses.length);
    }

    @org.testng.annotations.Test
    public void inner_class_type_correct() throws Exception {
        Class[] innerClasses = WaitlistContract.class.getDeclaredClasses();
        assertEquals("Cannot find inner class to complete unit test", 1, innerClasses.length);
        Class entryClass = innerClasses[0];
        assertTrue("Inner class should implement the BaseColumns interface", BaseColumns.class.isAssignableFrom(entryClass));
        assertTrue("Inner class should be final", Modifier.isFinal(entryClass.getModifiers()));
        assertTrue("Inner class should be static", Modifier.isStatic(entryClass.getModifiers()));
    }

    @org.testng.annotations.Test
    public void inner_class_members_correct() throws Exception {
        Class[] innerClasses = WaitlistContract.class.getDeclaredClasses();
        assertEquals("Cannot find inner class to complete unit test", 1, innerClasses.length);
        Class entryClass = innerClasses[0];
        Field[] allFields = entryClass.getDeclaredFields();
        assertEquals("There should be exactly 4 String members in the inner class", 4, allFields.length);
        for (Field field : allFields) {
            assertTrue("All members in the contract class should be Strings", field.getType()==String.class);
            assertTrue("All members in the contract class should be final", Modifier.isFinal(field.getModifiers()));
            assertTrue("All members in the contract class should be static", Modifier.isStatic(field.getModifiers()));
        }
    }
}