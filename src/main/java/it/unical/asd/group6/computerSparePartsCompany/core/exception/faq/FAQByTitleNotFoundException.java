package it.unical.asd.group6.computerSparePartsCompany.core.exception.faq;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.faq.classgeneric.FAQException;

public class FAQByTitleNotFoundException extends FAQException {

    public FAQByTitleNotFoundException(String title){super(String.format("No FAQ found with title %s",title));}
}
