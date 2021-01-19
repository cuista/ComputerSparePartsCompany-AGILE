package it.unical.asd.group6.computerSparePartsCompany.core.exception.faq;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.faq.classgeneric.FAQException;

public class FAQByDescriptionNotFoundException extends FAQException {

    public FAQByDescriptionNotFoundException(String description){super(String.format("No FAQ found with description %s",description));}
}
