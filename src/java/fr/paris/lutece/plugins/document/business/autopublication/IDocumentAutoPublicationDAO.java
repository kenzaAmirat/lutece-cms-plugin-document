/*
 * Copyright (c) 2002-2014, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.document.business.autopublication;

import fr.paris.lutece.plugins.document.business.spaces.DocumentSpace;
import fr.paris.lutece.portal.business.portlet.Portlet;

import java.util.Collection;


/**
 * This class porvides Data Access methods for DocumentAutoPublicationDAO interface
 *
 */
public interface IDocumentAutoPublicationDAO
{
    /**
     * Insert a new record in the table document_auto_publication
     *
     * @param documentAutoPublication the instance of the
     *            DocumentAutoPublication object to insert
     */
    void insert( DocumentAutoPublication documentAutoPublication );

    /**
     * Loads the data of Document Auto Publication whose identifier is specified in parameter
     *
     * @param nPortletId The {@link Portlet} identifier
     * @param nSpaceId The {@link DocumentSpace} identifier
     * @return The {@link DocumentAutoPublication} object
     */
    DocumentAutoPublication load( int nPortletId, int nSpaceId );

    /**
     * Loads all data Document Auto Publication
     *
     * @return The {@link Collection} of {@link DocumentAutoPublication} object
     */
    Collection<DocumentAutoPublication> load(  );

    /**
     * Load the list of Document Auto Publication whose portlet identifier is specified in parameter
     *
     * @param nPortletId The {@link Portlet} identifier
     * @return The {@link Collection} of {@link DocumentAutoPublication} object
     */
    Collection<DocumentAutoPublication> selectByPortletId( int nPortletId );

    /**
     * Load the list of Document Auto Publication whose {@link DocumentSpace} identifier is specified in parameter
     *
     * @param nSpaceId The {@link DocumentSpace} identifier
     * @return The {@link Collection} of {@link DocumentAutoPublication} object
     */
    Collection<DocumentAutoPublication> selectBySpaceId( int nSpaceId );

    /**
     * Update the record in the table
     *
     * @param documentAutoPublication The DocumentAutoPublication to update
     */
    void store( DocumentAutoPublication documentAutoPublication );

    /**
     * Delete records from a Document Auto Publication object identifier in the table document_auto_publication
     *
     * @param nPortletId the portlet identifier
     * @param nSpaceId the {@link DocumentSpace} identifier
     */
    void delete( int nPortletId, int nSpaceId );

    /**
     * Delete records from a portlet
     *
     * @param nPortletId the portlet identifier
     */
    void deleteAllSpaces( int nPortletId );
}
