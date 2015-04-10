
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
                  DATE: Fri Apr 10 11:59:44 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/master/navbar.scala.html
                  HASH: 9063dfc35e641997d19c31be04ad9e5080af2ca2
                  MATRIX: 728->1|875->17|903->64|930->65|1548->656|1563->662|1611->689|1834->885|1866->908|1906->910|1930->916|1943->921|1982->922|2025->934|2085->967|2100->973|2143->995|2264->1089|2304->1108|2353->1129|2424->1173|2446->1186|2494->1196|2543->1218|2591->1257|2630->1258|2683->1283|2722->1295|2754->1318|2794->1320|2818->1326|2831->1331|2870->1332|2913->1344|2981->1385|2996->1391|3039->1413|3171->1518|3213->1539|3270->1568|3368->1639|3400->1662|3440->1664|3464->1670|3477->1675|3516->1676|3559->1688|3627->1729|3642->1735|3676->1748|3749->1794|3764->1800|3811->1826|3897->1885|3939->1906|3996->1935|4083->1991|4132->2009|4173->2022|4518->2340|4534->2347|4570->2362|4746->2511|4768->2524|4816->2534|4877->2568|4925->2607|4964->2608|5029->2646|5071->2667|5124->2701|5137->2705|5176->2706|5241->2744|5286->2768|5351->2802|5412->2832|5469->2861|5534->2899|5550->2906|5587->2922|5640->2947|5941->3221|5953->3224|6034->3283|6170->3392|6213->3414|6270->3443
                  LINES: 26->1|29->1|31->4|32->5|45->18|45->18|45->18|53->26|53->26|53->26|53->26|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|57->30|59->32|59->32|59->32|60->33|60->33|60->33|61->34|61->34|61->34|61->34|61->34|61->34|61->34|61->34|62->35|62->35|62->35|64->37|64->37|65->38|67->40|67->40|67->40|67->40|67->40|67->40|67->40|68->41|68->41|68->41|69->42|69->42|69->42|70->43|70->43|71->44|73->46|74->47|75->48|82->55|82->55|82->55|85->58|85->58|85->58|86->59|86->59|86->59|87->60|87->60|88->61|88->61|88->61|89->62|89->62|90->63|91->64|92->65|93->66|93->66|93->66|94->67|99->72|99->72|99->72|101->74|101->74|102->75
                  -- GENERATED --
              */
          