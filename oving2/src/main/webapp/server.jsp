<%@page pageEncoding="UTF-8"%>
<%
    String fornavn = request.getParameter("fornavn");
    String etternavn = request.getParameter("etternavn");
    String interesse = request.getParameter("interesse");
%>
<html>
<head>
    <title>Resultat</title>
</head>
<body>
Hei <%= fornavn + " " + etternavn %>!
<h2><%= interesse %> ja, det er gøy. Her er noe info om det:</h2>
<p>
    Prosjektet vil i første omgang gjennomføres i delstatene New South Wales og Queensland på nord-østkysten av
    Australia.
    Dronen vil ikke bare redusere bruken av helikoptre, men kan også bidra til å redusere bruken av haibarrierer. Disse
    nettene er blitt kritisert for å fange truede arter og hai, selv om de har vært effektive i å holde hai unna
    populære strender.
    Noen av dronene er også utstyrt med livredningsutstyr som de kan slippe til hjelpetrengende surfere og svømmere.
    Selskapet bak, The Ripper Group, forteller selv at de også jobber med å utvikle en måte å jage bort haier, men de
    har så langt ikke sagt mer om hva slags type teknologi det er snakk om.
</p>
</body>
</html>