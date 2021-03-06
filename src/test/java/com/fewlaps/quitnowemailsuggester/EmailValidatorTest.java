package com.fewlaps.quitnowemailsuggester;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class EmailValidatorTest {

    EmailValidator ev;

    @Before
    public void init() {
        ev = new EmailValidator();
    }

    @Test
    public void shouldSayFalseForNull() {
        assertFalse(ev.isValidEmail(null));
    }

    @Test
    public void shouldSayFalseForEmpty() {
        assertFalse(ev.isValidEmail(""));
    }

    @Test
    public void shouldSayOK1() {
        assertTrue(ev.isValidEmail("roc@rocboron.at"));
    }

    @Test
    public void shouldSayOK2() {
        assertTrue(ev.isValidEmail("email@example.com"));
    }

    @Test
    public void shouldSayOK3() {
        assertTrue(ev.isValidEmail("firstname.lastname@example.com"));
    }

    @Test
    public void shouldSayOK4() {
        assertTrue(ev.isValidEmail("email@subdomain.example.com"));
    }

    @Test
    public void shouldSayOK5() {
        assertTrue(ev.isValidEmail("firstname+lastname@example.com"));
    }

    @Test
    public void shouldSayOK6() {
        assertTrue(ev.isValidEmail("1234567890@example.com"));
    }

    @Test
    public void shouldSayOK7() {
        assertTrue(ev.isValidEmail("email@example-one.com"));
    }

    @Test
    public void shouldSayOK8() {
        assertTrue(ev.isValidEmail("_______@example.com"));
    }

    @Test
    public void shouldSayOK9() {
        assertTrue(ev.isValidEmail("email@example.name"));
    }

    @Test
    public void shouldSayOK10() {
        assertTrue(ev.isValidEmail("email@example.museum"));
    }

    @Test
    public void shouldSayOK11() {
        assertTrue(ev.isValidEmail("email@example.co.jp"));
    }

    @Test
    public void shouldSayOK12() {
        assertTrue(ev.isValidEmail("firstname-lastname@example.com"));
    }

    @Test
    public void shouldSayKO1() {
        assertFalse(ev.isValidEmail("plainaddress"));
    }

    @Test
    public void shouldSayKO2() {
        assertFalse(ev.isValidEmail("#@%^%#$@#$@#.com"));
    }

    @Test
    public void shouldSayKO3() {
        assertFalse(ev.isValidEmail("@example.com"));
    }

    @Test
    public void shouldSayKO4() {
        assertFalse(ev.isValidEmail("Joe Smith <email@example.com>"));
    }

    @Test
    public void shouldSayKO5() {
        assertFalse(ev.isValidEmail("email.example.com"));
    }

    @Test
    public void shouldSayKO6() {
        assertFalse(ev.isValidEmail("email@example@example.com"));
    }

    @Test
    public void shouldSayKO7() {
        assertTrue(ev.isValidEmail(".email@example.com"));
    }

    @Test
    public void shouldSayKO8() {
        assertTrue(ev.isValidEmail("email.@example.com"));
    }

    @Test
    public void shouldSayKO9() {
        assertTrue(ev.isValidEmail("email..email@example.com"));
    }

    @Test
    public void shouldSayKO10() {
        assertFalse(ev.isValidEmail("?????@example.com"));
    }

    @Test
    public void shouldSayKO11() {
        assertFalse(ev.isValidEmail("email@example.com (Joe Smith)"));
    }

    @Test
    public void shouldSayKO12() {
        assertFalse(ev.isValidEmail("email@example"));
    }

    @Test
    public void shouldSayKO13() {
        assertTrue(ev.isValidEmail("email@111.222.333.44444"));
    }

    @Test
    public void shouldSayKO14() {
        assertFalse(ev.isValidEmail("email@example..com"));
    }

    @Test
    public void shouldSayKO15() {
        assertTrue(ev.isValidEmail("Abc..123@example.com"));
    }

    @Test
    public void shouldSayKO16() {
        assertFalse(ev.isValidEmail("�(),:;<>[\\]@example.com"));
    }

    @Test
    public void shouldSayKO17() {
        assertFalse(ev.isValidEmail("just\"not\"right@example.com"));
    }

    @Test
    public void shouldSayKO18() {
        assertFalse(ev.isValidEmail("this\\ is\"really\"not\\allowed@example.com"));
    }

    // Alias Email tests

    @Test
    public void aliasTest01(){
        assertTrue(ev.isAliasEmail("alias+test@example.com"));
    }

    @Test
    public void aliasTest02(){
        assertTrue(ev.isAliasEmail("alias+test+me@example.com"));
    }

    @Test
    public void aliasTest03(){
        assertTrue(ev.isAliasEmail("alias+e@example.com"));
    }

    @Test
    public void aliasTest04(){
        assertFalse(ev.isAliasEmail("alias@example.com"));
    }

    @Test
    public void aliasTest05(){
        assertFalse(ev.isAliasEmail("alias+me@.example.com"));
    }


}
