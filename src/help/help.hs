<helpset>
    <title>AYUDA</title>
    <maps>
        <homeID>index</homeID>		
        <mapref location="help.jhm"/>	
    </maps>            
                
    <view>						
        <name>toc</name>
        <label>Tabla contenidos</label>	
        <type>javax.help.TOCView</type>
        <data>helpTOC.xml</data>		
    </view>        
    <presentation default="true" displayviews="false" displayviewimages="true">
        <name>MainWin</name>
        <size width="750" height="400"/>		
        <location x="300" y="200"/>			
        <title></title> 
        <toolbar>	
            <helpaction image="BackwardIco">javax.help.BackAction</helpaction>
            <helpaction image="ForwardIco">javax.help.ForwardAction</helpaction>
            <helpaction image="imgAnhadirFavorito">javax.help.FavoritesAction</helpaction>                        
        </toolbar>
    </presentation>                



</helpset>