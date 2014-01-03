/*
 * FILENAME
 *     DecoratePattern.java
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

package decorator;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class DecoratePattern
{
    abstract class Component
    {
        public abstract void operation();
    }

    class ConcreteComponent extends Component
    {

        @Override
        public void operation()
        {
            System.out.println("This is concerete implemenation");
        }
    }

    abstract class Decorator extends Component
    {
        protected Component component;

        public void setComponent(Component component)
        {
            this.component = component;
        }

        @Override
        public void operation()
        {
            System.out.println("Inside Decorator");
            if (component != null)
            {
                component.operation();
            }
            System.out.println("Outside Decorator");
        }
    }

    class ConcreteDecoratorA extends Decorator
    {
        @Override
        public void operation()
        {
            super.operation(); //To change body of overridden methods use File | Settings | File Templates.
            System.out.println("Decorator A initialized");
        }
    }

    class ConcreteDecoratorB extends Decorator
    {
        @Override
        public void operation()
        {
            super.operation(); //To change body of overridden methods use File | Settings | File Templates.
            System.out.println("Decorator B initialized");
        }
    }
}
