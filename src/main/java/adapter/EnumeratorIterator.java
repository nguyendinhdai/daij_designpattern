/*
 * FILENAME
 *     EnumeratorIterator.java
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

package adapter;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

import java.util.Enumeration;
import java.util.Iterator;

/*
 * We are Adapting Enumeration to Iterator.
 * Adapter EnumeratorIterator implements Iterator to look like an Iterator
 */

public class EnumeratorIterator implements Iterator
{
    Enumeration enumeration;

    public EnumeratorIterator(Enumeration enumeration)
    {
        this.enumeration = enumeration;
    }

    // Iterator's hasNext() method is delegated to Enumerator's hasMoreElements()
    public boolean hasNext()
    {
        return enumeration.hasMoreElements();
    }

    // Iterator's next() method is delegated to Enumerator's nextElement()
    public Object next()
    {
        return enumeration.nextElement();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
