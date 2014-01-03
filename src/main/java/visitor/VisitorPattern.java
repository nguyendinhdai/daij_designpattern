/*
 * FILENAME
 *     VisitorPattern.java
 *
 * FILE LOCATION
 *     $Source$
 *
 * VERSION
 *     $Id$
 *         @version       $Revision$
 *         Check-Out Tag: $Name$
 *         Locked By:     $Lockers$
 *
 * FORMATTING NOTES
 *     * Lines should be limited to 78 characters.
 *     * Files should contain no tabs.
 *     * Indent code using four-character increments.
 *
 * COPYRIGHT
 *     Copyright (C) 2007 Genix Ventures Pty. Ltd. All rights reserved.
 *     This software is the confidential and proprietary information of
 *     Genix Ventures ("Confidential Information"). You shall not
 *     disclose such Confidential Information and shall use it only in
 *     accordance with the terms of the license agreement you entered into
 *     with Genix Ventures.
 */

package visitor;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class VisitorPattern
{

    public static void print(GenderVisitor visitor, Gender gender)
    {
        gender.callBack(visitor);
    }

    public static void main(String[] args)
    {
        Gender gender = new Male();
        GenderVisitor visitor = new EnglishPrinter();
        print(visitor, gender);

    }

    static interface Gender
    {

        public double averageHeight();

        public void callBack(GenderVisitor visitor);
    }

    static class Male implements Gender
    {

        public void callBack(GenderVisitor visitor)
        {
            visitor.visit(this);
        }

        public double averageHeight()
        {
            return 5.9;
        }
    }

    static class Female implements Gender
    {

        public void callBack(GenderVisitor visitor)
        {
            visitor.visit(this);
        }

        public double averageHeight()
        {
            return 5.5;
        }
    }

    static interface GenderVisitor
    {

        public void visit(Gender unknown);

        public void visit(Female female);

        public void visit(Male male);
    }

    static class EnglishPrinter implements GenderVisitor
    {

        public void visit(Gender unknown)
        {
            System.out.println("unknown, height = " + unknown.averageHeight());
        }

        public void visit(Female female)
        {
            System.out.println("female, height = " + female.averageHeight());
        }

        public void visit(Male male)
        {
            System.out.println("male, height = " + male.averageHeight());
        }
    }

    static class FrenchPrinter implements GenderVisitor
    {

        public void visit(Gender unknown)
        {
            System.out.println("inconnu, hauteur = " + unknown.averageHeight());
        }

        public void visit(Female female)
        {
            System.out.println("fŽminin, hauteur = " + female.averageHeight());
        }

        public void visit(Male male)
        {
            System.out.println("masculin, hauteur = " + male.averageHeight());
        }
    }

    static class GermanPrinter implements GenderVisitor
    {

        public void visit(Gender unknown)
        {
            System.out.println("unbekannte, Hšhe = " + unknown.averageHeight());
        }

        public void visit(Female female)
        {
            System.out.println("weiblich, Hšhe = " + female.averageHeight());
        }

        public void visit(Male male)
        {
            System.out.println("mŠnnlich, Hšhe = " + male.averageHeight());
        }
    }
}
