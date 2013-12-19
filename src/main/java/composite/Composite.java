/*
 * FILENAME
 *     Composite.java
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

package composite;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite implements Component
{
    private String name;
    private String description;

    // list of State Components
    List<Component> components = new ArrayList<Component>();

    public Composite(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public void add(Component state)
    {
        components.add(state);
    }

    public void remove(Component state)
    {
        components.remove(state);
    }

    public Component getChild(int i)
    {
        return components.get(i);
    }

    public void print()
    {
        System.out.println("-------------");
        System.out.println("Name =" + getName());
        System.out.println("Description =" + getDescription());
        System.out.println("-------------");
        Iterator<Component> iterator = components.iterator();
        while (iterator.hasNext())
        {
            Component component = iterator.next();
            component.print();
        }
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
