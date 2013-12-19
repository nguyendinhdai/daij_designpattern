/*
 * FILENAME
 *     FlyWeightFactory.java
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

package flyweight;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

import java.util.HashMap;

public class FlyWeightFactory
{
    private HashMap<String, IFlyWeight> lstFlyweight;
    private static FlyWeightFactory factory = new FlyWeightFactory();

    private FlyWeightFactory()
    {
        lstFlyweight = new HashMap<String, IFlyWeight>();
    }

    public synchronized IFlyWeight getFlyweight(String divisionName)
    {
        if (lstFlyweight.get(divisionName) == null)
        {
            IFlyWeight fw = new FlyWeight(divisionName);
            lstFlyweight.put(divisionName, fw);
            return fw;
        }
        else
        {
            return (IFlyWeight) lstFlyweight.get(divisionName);
        }
    }

    public static FlyWeightFactory getInstance()
    {
        return factory;
    }

    //Inner flyweight class
    private class FlyWeight implements IFlyWeight
    {
        private String name;
        private String addr;

        private void setValues(String name, String addr)
        {
            this.name = name;
            this.addr = addr;
        }

        private FlyWeight(String division)
        {
            if (division.equals("North"))
            {
                setValues("soniya", "addr1");
            }
            if (division.equals("South"))
            {
                setValues("rahul", "addr2");
            }
            if (division.equals("East"))
            {
                setValues("Aqil", "addr3");
            }
        }

        public String getName()
        {
            return name;
        }

        public String getAddress()
        {
            return addr;
        }
    }// end of Flyweight
}// end of FlyweightFactory
