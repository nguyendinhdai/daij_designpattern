/*
 * FILENAME
 *     FileWriterUtil.java
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

package com.journaldev.design.memento;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class FileWriterUtil
{

    private String fileName;
    private StringBuilder content;

    public FileWriterUtil(String file)
    {
        this.fileName = file;
        this.content = new StringBuilder();
    }

    @Override
    public String toString()
    {
        return this.content.toString();
    }

    public void write(String str)
    {
        content.append(str);
    }

    public Memento save()
    {
        return new Memento(this.fileName, this.content);
    }

    public void undoToLastSave(Object obj)
    {
        Memento memento = (Memento) obj;
        this.fileName = memento.fileName;
        this.content = memento.content;
    }

    private class Memento
    {
        private String fileName;
        private StringBuilder content;

        public Memento(String file, StringBuilder content)
        {
            this.fileName = file;
            //notice the deep copy so that Memento and FileWriterUtil content variables don't refer to same object
            this.content = new StringBuilder(content);
        }
    }
}
