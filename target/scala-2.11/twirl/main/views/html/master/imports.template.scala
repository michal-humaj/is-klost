
package views.html.master

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object imports extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(bodyClass: String)(body: Html)(javascripts: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.67*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <meta charset="utf-8"/>

        <title>IS Klost | """),_display_(/*9.28*/title),format.raw/*9.33*/("""</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

        <link rel="icon" type="image/png" href=""""),_display_(/*13.50*/routes/*13.56*/.Assets.at("img/favicon.png")),format.raw/*13.85*/("""">

        <link rel="stylesheet" href='"""),_display_(/*15.39*/routes/*15.45*/.Assets.at("css/bootstrap.min.css")),format.raw/*15.80*/("""'/>
        <link rel="stylesheet" href='"""),_display_(/*16.39*/routes/*16.45*/.Assets.at("css/font-awesome.min.css")),format.raw/*16.83*/("""'/>
        <link rel="stylesheet" href='"""),_display_(/*17.39*/routes/*17.45*/.Assets.at("css/ace-fonts.min.css")),format.raw/*17.80*/("""'/>

            <!-- 3rd party CSS -->
        <link rel="stylesheet" href='"""),_display_(/*20.39*/routes/*20.45*/.Assets.at("css/jquery-ui.min.css")),format.raw/*20.80*/("""'/>
        <link rel="stylesheet" href='"""),_display_(/*21.39*/routes/*21.45*/.Assets.at("css/jquery.gritter.min.css")),format.raw/*21.85*/("""'/>
        <link rel="stylesheet" href='"""),_display_(/*22.39*/routes/*22.45*/.Assets.at("css/fullcalendar.min.css")),format.raw/*22.83*/("""'/>

        <link rel="stylesheet" href='"""),_display_(/*24.39*/routes/*24.45*/.Assets.at("css/ace.min.css")),format.raw/*24.74*/("""' class="ace-main-stylesheet" id="main-ace-style"/>
        <link rel="stylesheet" href='"""),_display_(/*25.39*/routes/*25.45*/.Assets.at("css/custom.css")),format.raw/*25.73*/("""'/>
    </head>

    <body class=""""),_display_(/*28.19*/bodyClass),format.raw/*28.28*/("""">

        """),_display_(/*30.10*/body),format.raw/*30.14*/("""

        """),format.raw/*32.9*/("""<script src='"""),_display_(/*32.23*/routes/*32.29*/.Assets.at("js/lib/jquery.min.js")),format.raw/*32.63*/("""'></script>
        <script src='"""),_display_(/*33.23*/routes/*33.29*/.Assets.at("js/lib/bootstrap.min.js")),format.raw/*33.66*/("""'></script>
            <!-- 3rd party JS -->
        <script src='"""),_display_(/*35.23*/routes/*35.29*/.Assets.at("js/lib/jquery-ui.min.js")),format.raw/*35.66*/("""'></script>
        <script src='"""),_display_(/*36.23*/routes/*36.29*/.Assets.at("js/lib/jquery.gritter.min.js")),format.raw/*36.71*/("""'></script>
        <script src='"""),_display_(/*37.23*/routes/*37.29*/.Assets.at("js/lib/moment.min.js")),format.raw/*37.63*/("""'></script>
        <script src='"""),_display_(/*38.23*/routes/*38.29*/.Assets.at("js/lib/fullcalendar.min.js")),format.raw/*38.69*/("""'></script>

        <script src='"""),_display_(/*40.23*/routes/*40.29*/.Assets.at("js/lib/ace-elements.min.js")),format.raw/*40.69*/("""'></script>
        <script src='"""),_display_(/*41.23*/routes/*41.29*/.Assets.at("js/lib/ace.js")),format.raw/*41.56*/("""'></script>

            <!-- Custom JS -->
        <script src='"""),_display_(/*44.23*/routes/*44.29*/.Assets.at("js/common.js")),format.raw/*44.55*/("""'></script>

        """),_display_(/*46.10*/javascripts),format.raw/*46.21*/("""

    """),format.raw/*48.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,bodyClass:String,body:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(bodyClass)(body)(javascripts)

  def f:((String) => (String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (bodyClass) => (body) => (javascripts) => apply(title)(bodyClass)(body)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Feb 02 12:51:47 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/master/imports.scala.html
                  HASH: 45734f6dde76a3be31ffbff5fcd488b98b8e63b2
                  MATRIX: 749->1|902->66|930->68|1132->244|1157->249|1343->408|1358->414|1408->443|1477->485|1492->491|1548->526|1617->568|1632->574|1691->612|1760->654|1775->660|1831->695|1936->773|1951->779|2007->814|2076->856|2091->862|2152->902|2221->944|2236->950|2295->988|2365->1031|2380->1037|2430->1066|2547->1156|2562->1162|2611->1190|2673->1225|2703->1234|2743->1247|2768->1251|2805->1261|2846->1275|2861->1281|2916->1315|2977->1349|2992->1355|3050->1392|3145->1460|3160->1466|3218->1503|3279->1537|3294->1543|3357->1585|3418->1619|3433->1625|3488->1659|3549->1693|3564->1699|3625->1739|3687->1774|3702->1780|3763->1820|3824->1854|3839->1860|3887->1887|3980->1953|3995->1959|4042->1985|4091->2007|4123->2018|4156->2024
                  LINES: 26->1|29->1|31->3|37->9|37->9|41->13|41->13|41->13|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|56->28|56->28|58->30|58->30|60->32|60->32|60->32|60->32|61->33|61->33|61->33|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|68->40|68->40|69->41|69->41|69->41|72->44|72->44|72->44|74->46|74->46|76->48
                  -- GENERATED --
              */
          