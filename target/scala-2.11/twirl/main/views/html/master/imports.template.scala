
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
        <script src='"""),_display_(/*44.23*/routes/*44.29*/.Assets.at("js/lib/spin.min.js")),format.raw/*44.61*/("""'></script>

        <script src='"""),_display_(/*46.23*/routes/*46.29*/.Assets.at("js/lib/ace-elements.min.js")),format.raw/*46.69*/("""'></script>
        <script src='"""),_display_(/*47.23*/routes/*47.29*/.Assets.at("js/lib/ace.js")),format.raw/*47.56*/("""'></script>

            <!-- Custom JS -->
        <script src='"""),_display_(/*50.23*/routes/*50.29*/.Assets.at("js/common.js")),format.raw/*50.55*/("""'></script>
        <script src='"""),_display_(/*51.23*/routes/*51.29*/.App.jsMessages()),format.raw/*51.46*/("""'></script>

        """),_display_(/*53.10*/javascripts),format.raw/*53.21*/("""

    """),format.raw/*55.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,bodyClass:String,body:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(bodyClass)(body)(javascripts)

  def f:((String) => (String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (bodyClass) => (body) => (javascripts) => apply(title)(bodyClass)(body)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 13:14:05 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/master/imports.scala.html
                  HASH: 31e0bb0efaf644906d352ee331ad470582004e24
                  MATRIX: 749->1|902->66|932->70|1140->252|1165->257|1355->420|1370->426|1420->455|1491->499|1506->505|1562->540|1632->583|1647->589|1706->627|1776->670|1791->676|1847->711|1955->792|1970->798|2026->833|2096->876|2111->882|2172->922|2242->965|2257->971|2316->1009|2388->1054|2403->1060|2453->1089|2571->1180|2586->1186|2635->1214|2700->1252|2730->1261|2770->1274|2795->1278|2834->1290|2875->1304|2890->1310|2926->1325|2988->1360|3003->1366|3058->1400|3120->1435|3135->1441|3193->1478|3290->1548|3305->1554|3363->1591|3425->1626|3440->1632|3503->1674|3565->1709|3580->1715|3635->1749|3697->1784|3712->1790|3773->1830|3835->1865|3850->1871|3899->1899|3961->1934|3976->1940|4023->1966|4085->2001|4100->2007|4163->2049|4225->2084|4240->2090|4308->2137|4370->2172|4385->2178|4435->2207|4497->2242|4512->2248|4565->2280|4629->2317|4644->2323|4705->2363|4767->2398|4782->2404|4830->2431|4926->2500|4941->2506|4988->2532|5050->2567|5065->2573|5103->2590|5154->2614|5186->2625|5221->2633
                  LINES: 26->1|29->1|31->3|37->9|37->9|41->13|41->13|41->13|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|56->28|56->28|57->29|57->29|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|74->46|74->46|74->46|75->47|75->47|75->47|78->50|78->50|78->50|79->51|79->51|79->51|81->53|81->53|83->55
                  -- GENERATED --
              */
          