
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
        """),_display_(/*29.10*/body),format.raw/*29.14*/("""

        """),format.raw/*31.9*/("""<script src=""""),_display_(/*31.23*/routes/*31.29*/.App.jsRoutes()),format.raw/*31.44*/(""""></script>
        <script src='"""),_display_(/*32.23*/routes/*32.29*/.Assets.at("js/lib/jquery.min.js")),format.raw/*32.63*/("""'></script>
        <script src='"""),_display_(/*33.23*/routes/*33.29*/.Assets.at("js/lib/bootstrap.min.js")),format.raw/*33.66*/("""'></script>
            <!-- 3rd party JS -->
        <script src='"""),_display_(/*35.23*/routes/*35.29*/.Assets.at("js/lib/jquery-ui.min.js")),format.raw/*35.66*/("""'></script>
        <script src='"""),_display_(/*36.23*/routes/*36.29*/.Assets.at("js/lib/jquery.gritter.min.js")),format.raw/*36.71*/("""'></script>
        <script src='"""),_display_(/*37.23*/routes/*37.29*/.Assets.at("js/lib/moment.min.js")),format.raw/*37.63*/("""'></script>
        <script src='"""),_display_(/*38.23*/routes/*38.29*/.Assets.at("js/lib/fullcalendar.min.js")),format.raw/*38.69*/("""'></script>
        <script src='"""),_display_(/*39.23*/routes/*39.29*/.Assets.at("js/lib/gcal.js")),format.raw/*39.57*/("""'></script>
        <script src='"""),_display_(/*40.23*/routes/*40.29*/.Assets.at("js/lib/sk.js")),format.raw/*40.55*/("""'></script>
        <script src='"""),_display_(/*41.23*/routes/*41.29*/.Assets.at("js/lib/knockout-3.2.0.min.js")),format.raw/*41.71*/("""'></script>
        <script src='"""),_display_(/*42.23*/routes/*42.29*/.Assets.at("js/lib/knockout.validation.min.js")),format.raw/*42.76*/("""'></script>
        <script src='"""),_display_(/*43.23*/routes/*43.29*/.Assets.at("js/lib/sk-SK.js")),format.raw/*43.58*/("""'></script>

        <script src='"""),_display_(/*45.23*/routes/*45.29*/.Assets.at("js/lib/ace-elements.min.js")),format.raw/*45.69*/("""'></script>
        <script src='"""),_display_(/*46.23*/routes/*46.29*/.Assets.at("js/lib/ace.js")),format.raw/*46.56*/("""'></script>

            <!-- Custom JS -->
        <script src='"""),_display_(/*49.23*/routes/*49.29*/.Assets.at("js/common.js")),format.raw/*49.55*/("""'></script>
        <script src='"""),_display_(/*50.23*/routes/*50.29*/.App.jsMessages()),format.raw/*50.46*/("""'></script>

        """),_display_(/*52.10*/javascripts),format.raw/*52.21*/("""

    """),format.raw/*54.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,bodyClass:String,body:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(bodyClass)(body)(javascripts)

  def f:((String) => (String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (bodyClass) => (body) => (javascripts) => apply(title)(bodyClass)(body)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Mar 09 21:31:40 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/master/imports.scala.html
                  HASH: c35fd269b8ba6ffd1028fbcaf92eabfe03fba982
                  MATRIX: 749->1|902->66|930->68|1132->244|1157->249|1343->408|1358->414|1408->443|1477->485|1492->491|1548->526|1617->568|1632->574|1691->612|1760->654|1775->660|1831->695|1936->773|1951->779|2007->814|2076->856|2091->862|2152->902|2221->944|2236->950|2295->988|2365->1031|2380->1037|2430->1066|2547->1156|2562->1162|2611->1190|2673->1225|2703->1234|2742->1246|2767->1250|2804->1260|2845->1274|2860->1280|2896->1295|2957->1329|2972->1335|3027->1369|3088->1403|3103->1409|3161->1446|3256->1514|3271->1520|3329->1557|3390->1591|3405->1597|3468->1639|3529->1673|3544->1679|3599->1713|3660->1747|3675->1753|3736->1793|3797->1827|3812->1833|3861->1861|3922->1895|3937->1901|3984->1927|4045->1961|4060->1967|4123->2009|4184->2043|4199->2049|4267->2096|4328->2130|4343->2136|4393->2165|4455->2200|4470->2206|4531->2246|4592->2280|4607->2286|4655->2313|4748->2379|4763->2385|4810->2411|4871->2445|4886->2451|4924->2468|4973->2490|5005->2501|5038->2507
                  LINES: 26->1|29->1|31->3|37->9|37->9|41->13|41->13|41->13|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|56->28|56->28|57->29|57->29|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|73->45|73->45|73->45|74->46|74->46|74->46|77->49|77->49|77->49|78->50|78->50|78->50|80->52|80->52|82->54
                  -- GENERATED --
              */
          