/*
 * Copyright (c) 2002-2011, Mairie de Paris
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
package fr.paris.lutece.plugins.document.business.portlet;

import fr.paris.lutece.portal.business.portlet.IPortletInterfaceDAO;
import fr.paris.lutece.portal.business.portlet.PortletHome;
import fr.paris.lutece.portal.business.portlet.PortletTypeHome;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.util.ReferenceItem;

import java.util.Collection;
import java.util.List;


public class DocumentPortletHome extends PortletHome
{
    /////////////////////////////////////////////////////////////////////////////////
    // Constants
    // Static variable pointed at the DAO instance
    private static IDocumentPortletDAO _dao = (IDocumentPortletDAO) SpringContextService.getPluginBean( "document",
            "document.documentPortletDAO" );

    /* This class implements the Singleton design pattern. */
    private static DocumentPortletHome _singleton = null;

    /**
     * Constructor
     */
    public DocumentPortletHome(  )
    {
        if ( _singleton == null )
        {
            _singleton = this;
        }
    }

    /**
     * Returns the instance of DocumentPortletHome
     *
     * @return the DocumentPortletHome instance
     */
    public static PortletHome getInstance(  )
    {
        if ( _singleton == null )
        {
            _singleton = new DocumentPortletHome(  );
        }

        return _singleton;
    }

    /**
     * Returns the identifier of the portlet type
     *
     * @return the portlet type identifier
     */
    public String getPortletTypeId(  )
    {
        String strCurrentClassName = this.getClass(  ).getName(  );
        String strPortletTypeId = PortletTypeHome.getPortletTypeId( strCurrentClassName );

        return strPortletTypeId;
    }

    /**
     * Returns the instance of the portlet DAO singleton
     *
     * @return the instance of the DAO singleton
     */
    public IPortletInterfaceDAO getDAO(  )
    {
        return _dao;
    }

    /**
     * Returns a list of couple id_portlet/name filtered by documentType and category
     * @param nDocumentId the Document ID
     * @param strCodeDocumentType the code
     * @param pOrder the order of the portlets
     * @return A collection of referenceItem
     */
    public static Collection<ReferenceItem> findByCodeDocumentTypeAndCategory( int nDocumentId,
        String strCodeDocumentType, PortletOrder pOrder )
    {
        //FIXME : method should access to different home business methods
        return _dao.selectByDocumentOdAndDocumentType( nDocumentId, strCodeDocumentType, pOrder );
    }

    public static boolean checkIsAliasPortlet( int nPortletId )
    {
        return _dao.checkIsAliasPortlet( nPortletId );
    }

    /**
     * Finds all portlets that contains the document
     * @param nDocumentId document id
     * @return all portlets id.
     */
    public static List<Integer> findPortletForDocument( int nDocumentId )
    {
        return _dao.selectPortletsByDocumentId( nDocumentId );
    }
}
