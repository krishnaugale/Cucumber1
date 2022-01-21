package io.cucumber.config;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class FieldSetterContract {
    private final MyConfig testing = new MyConfig();
    private final FieldSetter fieldSetter = new FieldSetter(testing);

    @Before
    public void setFields() {
        fieldSetter.setFields(makeMapBuilder(testing).buildMap());
    }

    @Test
    public void sets_boolean_field() {
        assertTrue(testing.somebool);
    }

    @Test
    public void sets_string_field() {
        assertEquals("hello", testing.message);
    }

    @Test
    public void sets_int_field() {
        assertEquals(42, testing.meaning);
    }

    @Test
    public void sets_string_list_field() {
        assertEquals("one", testing.stringlist.get(0));
        assertEquals("two", testing.stringlist.get(1));
    }

    @Test
    public void sets_enum_field() {
        assertEquals(MyConfig.Myenum.BAR, testing.myenum);
    }

    @Test
    public void sets_pattern_field() {
        assertEquals("^hello$", testing.regexp.pattern());
    }

    protected abstract MapBuilder makeMapBuilder(Object config);

}
