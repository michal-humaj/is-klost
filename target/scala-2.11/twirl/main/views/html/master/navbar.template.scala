
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
object navbar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tabNumber: Int):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import com.feth.play.module.pa.views.html._

Seq[Any](format.raw/*1.18*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.1*/("""<div id="navbar" class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-container" id="navbar-container">

        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <img src='"""),_display_(/*18.32*/routes/*18.38*/.Assets.at("img/klost.png")),format.raw/*18.65*/("""'>
                </small>
            </a>
        </div>

        <div class="navbar-buttons navbar-header" role="navigation">
            <ul class="nav ace-nav">

                <li class='"""),_display_(/*26.29*/if(tabNumber.equals(0))/*26.52*/ {_display_(Seq[Any](format.raw/*26.54*/("""grey""")))}/*26.60*/else/*26.65*/{_display_(Seq[Any](format.raw/*26.66*/("""transparent""")))}),format.raw/*26.78*/("""'>
                    <a href='"""),_display_(/*27.31*/routes/*27.37*/.App.calendar("TODAY")),format.raw/*27.59*/("""'>
                        <i class="ace-icon fa fa-calendar-o"></i>
                        """),_display_(/*29.26*/Messages("nav.cal")),format.raw/*29.45*/("""
                    """),format.raw/*30.21*/("""</a>
                </li>
                """),_display_(/*32.18*/currentAuth()/*32.31*/ { auth =>_display_(Seq[Any](format.raw/*32.41*/("""
                    """),_display_(/*33.22*/if(LoggedAdmin.isAdminId(auth.getId()))/*33.61*/{_display_(Seq[Any](format.raw/*33.62*/("""
                        """),format.raw/*34.25*/("""<li class='"""),_display_(/*34.37*/if(tabNumber.equals(1))/*34.60*/ {_display_(Seq[Any](format.raw/*34.62*/("""grey""")))}/*34.68*/else/*34.73*/{_display_(Seq[Any](format.raw/*34.74*/("""transparent""")))}),format.raw/*34.86*/("""'>
                            <a href='"""),_display_(/*35.39*/routes/*35.45*/.App.store("TOMORROW")),format.raw/*35.67*/("""'>
                                <i class="ace-icon fa fa-cubes"></i>
                                """),_display_(/*37.34*/Messages("nav.store")),format.raw/*37.55*/("""
                            """),format.raw/*38.29*/("""</a>
                        </li>
                        <li class='"""),_display_(/*40.37*/if(tabNumber.equals(2))/*40.60*/ {_display_(Seq[Any](format.raw/*40.62*/("""grey""")))}/*40.68*/else/*40.73*/{_display_(Seq[Any](format.raw/*40.74*/("""transparent""")))}),format.raw/*40.86*/("""'>
                            <a href='"""),_display_(/*41.39*/routes/*41.45*/.Tents.list()),format.raw/*41.58*/("""'>
                                <img src='"""),_display_(/*42.44*/routes/*42.50*/.Assets.at("img/tent.png")),format.raw/*42.76*/("""' width="24" height="24">
                                """),_display_(/*43.34*/Messages("nav.tents")),format.raw/*43.55*/("""
                            """),format.raw/*44.29*/("""</a>
                        </li>
                    """)))}),format.raw/*46.22*/("""
                """)))}),format.raw/*47.18*/("""
            """),format.raw/*48.13*/("""</ul>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="transparent">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src='"""),_display_(/*55.59*/session/*55.66*/.get("picture")),format.raw/*55.81*/("""' alt="Users's profile picture" />
                        <span class="user-info">
                            <small>
                            """),_display_(/*58.30*/currentAuth()/*58.43*/ { auth =>_display_(Seq[Any](format.raw/*58.53*/("""
                                """),_display_(/*59.34*/if(LoggedAdmin.isAdminId(auth.getId()))/*59.73*/{_display_(Seq[Any](format.raw/*59.74*/("""
                                    """),_display_(/*60.38*/Messages("nav.admin")),format.raw/*60.59*/("""
                                """)))}/*61.34*/else/*61.38*/{_display_(Seq[Any](format.raw/*61.39*/("""
                                    """),_display_(/*62.38*/Messages("nav.storeman")),format.raw/*62.62*/("""
                                """)))}),format.raw/*63.34*/("""
                            """)))}),format.raw/*64.30*/("""
                            """),format.raw/*65.29*/("""</small>
                            """),_display_(/*66.30*/session/*66.37*/.get("username")),format.raw/*66.53*/("""
                        """),format.raw/*67.25*/("""</span>
                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>
                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-caret dropdown-closer">
                        <li>
                            <a href='"""),_display_(/*72.39*/com/*72.42*/.feth.play.module.pa.controllers.routes.Authenticate.logout),format.raw/*72.101*/("""'>
                                <i class="ace-icon fa fa-power-off"></i>
                                """),_display_(/*74.34*/Messages("btn.logout")),format.raw/*74.56*/("""
                            """),format.raw/*75.29*/("""</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

    </div>
</div>


"""))}
  }

  def render(tabNumber:Int): play.twirl.api.HtmlFormat.Appendable = apply(tabNumber)

  def f:((Int) => play.twirl.api.HtmlFormat.Appendable) = (tabNumber) => apply(tabNumber)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Apr 08 17:32:51 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/master/navbar.scala.html
                  HASH: c59928f0033a03deb487492cf37bbceaeb4a9900
                  MATRIX: 728->1|875->17|905->67|933->69|1564->673|1579->679|1627->706|1858->910|1890->933|1930->935|1954->941|1967->946|2006->947|2049->959|2110->993|2125->999|2168->1021|2291->1117|2331->1136|2381->1158|2454->1204|2476->1217|2524->1227|2574->1250|2622->1289|2661->1290|2715->1316|2754->1328|2786->1351|2826->1353|2850->1359|2863->1364|2902->1365|2945->1377|3014->1419|3029->1425|3072->1447|3206->1554|3248->1575|3306->1605|3406->1678|3438->1701|3478->1703|3502->1709|3515->1714|3554->1715|3597->1727|3666->1769|3681->1775|3715->1788|3789->1835|3804->1841|3851->1867|3938->1927|3980->1948|4038->1978|4127->2036|4177->2055|4219->2069|4571->2394|4587->2401|4623->2416|4802->2568|4824->2581|4872->2591|4934->2626|4982->2665|5021->2666|5087->2705|5129->2726|5183->2761|5196->2765|5235->2766|5301->2805|5346->2829|5412->2864|5474->2895|5532->2925|5598->2964|5614->2971|5651->2987|5705->3013|6011->3292|6023->3295|6104->3354|6242->3465|6285->3487|6343->3517
                  LINES: 26->1|29->1|31->4|32->5|45->18|45->18|45->18|53->26|53->26|53->26|53->26|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|57->30|59->32|59->32|59->32|60->33|60->33|60->33|61->34|61->34|61->34|61->34|61->34|61->34|61->34|61->34|62->35|62->35|62->35|64->37|64->37|65->38|67->40|67->40|67->40|67->40|67->40|67->40|67->40|68->41|68->41|68->41|69->42|69->42|69->42|70->43|70->43|71->44|73->46|74->47|75->48|82->55|82->55|82->55|85->58|85->58|85->58|86->59|86->59|86->59|87->60|87->60|88->61|88->61|88->61|89->62|89->62|90->63|91->64|92->65|93->66|93->66|93->66|94->67|99->72|99->72|99->72|101->74|101->74|102->75
                  -- GENERATED --
              */
          