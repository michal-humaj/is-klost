
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

                <li class='"""),_display_(/*33.29*/if(tabNumber.equals(1))/*33.52*/ {_display_(Seq[Any](format.raw/*33.54*/("""grey""")))}/*33.60*/else/*33.65*/{_display_(Seq[Any](format.raw/*33.66*/("""transparent""")))}),format.raw/*33.78*/("""'>
                    <a href='"""),_display_(/*34.31*/routes/*34.37*/.App.store("TOMORROW")),format.raw/*34.59*/("""'>
                        <i class="ace-icon fa fa-cubes"></i>
                        """),_display_(/*36.26*/Messages("nav.store")),format.raw/*36.47*/("""
                    """),format.raw/*37.21*/("""</a>
                </li>
                """),_display_(/*39.18*/currentAuth()/*39.31*/ { auth =>_display_(Seq[Any](format.raw/*39.41*/("""
                    """),_display_(/*40.22*/if(LoggedAdmin.isAdminId(auth.getId()))/*40.61*/{_display_(Seq[Any](format.raw/*40.62*/("""
                        """),format.raw/*41.25*/("""<li class='"""),_display_(/*41.37*/if(tabNumber.equals(2))/*41.60*/ {_display_(Seq[Any](format.raw/*41.62*/("""grey""")))}/*41.68*/else/*41.73*/{_display_(Seq[Any](format.raw/*41.74*/("""transparent""")))}),format.raw/*41.86*/("""'>
                            <a href='"""),_display_(/*42.39*/routes/*42.45*/.Tents.list()),format.raw/*42.58*/("""'>
                                <img src='"""),_display_(/*43.44*/routes/*43.50*/.Assets.at("img/tent.png")),format.raw/*43.76*/("""' width="24" height="24">
                                """),_display_(/*44.34*/Messages("nav.tents")),format.raw/*44.55*/("""
                            """),format.raw/*45.29*/("""</a>
                        </li>
                    """)))}),format.raw/*47.22*/("""
                """)))}),format.raw/*48.18*/("""
            """),format.raw/*49.13*/("""</ul>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="transparent">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src='"""),_display_(/*56.59*/session/*56.66*/.get("picture")),format.raw/*56.81*/("""' alt="Users's profile picture" />
                        <span class="user-info">
                            <small>
                            """),_display_(/*59.30*/currentAuth()/*59.43*/ { auth =>_display_(Seq[Any](format.raw/*59.53*/("""
                                """),_display_(/*60.34*/if(LoggedAdmin.isAdminId(auth.getId()))/*60.73*/{_display_(Seq[Any](format.raw/*60.74*/("""
                                    """),_display_(/*61.38*/Messages("nav.admin")),format.raw/*61.59*/("""
                                """)))}/*62.34*/else/*62.38*/{_display_(Seq[Any](format.raw/*62.39*/("""
                                    """),_display_(/*63.38*/Messages("nav.storeman")),format.raw/*63.62*/("""
                                """)))}),format.raw/*64.34*/("""
                            """)))}),format.raw/*65.30*/("""
                            """),format.raw/*66.29*/("""</small>
                            """),_display_(/*67.30*/session/*67.37*/.get("username")),format.raw/*67.53*/("""
                        """),format.raw/*68.25*/("""</span>
                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>
                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-caret dropdown-closer">
                        <li>
                            <a href='"""),_display_(/*73.39*/com/*73.42*/.feth.play.module.pa.controllers.routes.Authenticate.logout),format.raw/*73.101*/("""'>
                                <i class="ace-icon fa fa-power-off"></i>
                                """),_display_(/*75.34*/Messages("btn.logout")),format.raw/*75.56*/("""
                            """),format.raw/*76.29*/("""</a>
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
                  DATE: Sun Mar 15 10:05:15 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/master/navbar.scala.html
                  HASH: b60b80ea77468327d31089d993e38bd026a592a0
                  MATRIX: 728->1|875->17|905->67|933->69|1564->673|1579->679|1627->706|1858->910|1890->933|1930->935|1954->941|1967->946|2006->947|2049->959|2110->993|2125->999|2168->1021|2291->1117|2331->1136|2381->1158|2467->1217|2499->1240|2539->1242|2563->1248|2576->1253|2615->1254|2658->1266|2719->1300|2734->1306|2777->1328|2895->1419|2937->1440|2987->1462|3060->1508|3082->1521|3130->1531|3180->1554|3228->1593|3267->1594|3321->1620|3360->1632|3392->1655|3432->1657|3456->1663|3469->1668|3508->1669|3551->1681|3620->1723|3635->1729|3669->1742|3743->1789|3758->1795|3805->1821|3892->1881|3934->1902|3992->1932|4081->1990|4131->2009|4173->2023|4525->2348|4541->2355|4577->2370|4756->2522|4778->2535|4826->2545|4888->2580|4936->2619|4975->2620|5041->2659|5083->2680|5137->2715|5150->2719|5189->2720|5255->2759|5300->2783|5366->2818|5428->2849|5486->2879|5552->2918|5568->2925|5605->2941|5659->2967|5965->3246|5977->3249|6058->3308|6196->3419|6239->3441|6297->3471
                  LINES: 26->1|29->1|31->4|32->5|45->18|45->18|45->18|53->26|53->26|53->26|53->26|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|57->30|60->33|60->33|60->33|60->33|60->33|60->33|60->33|61->34|61->34|61->34|63->36|63->36|64->37|66->39|66->39|66->39|67->40|67->40|67->40|68->41|68->41|68->41|68->41|68->41|68->41|68->41|68->41|69->42|69->42|69->42|70->43|70->43|70->43|71->44|71->44|72->45|74->47|75->48|76->49|83->56|83->56|83->56|86->59|86->59|86->59|87->60|87->60|87->60|88->61|88->61|89->62|89->62|89->62|90->63|90->63|91->64|92->65|93->66|94->67|94->67|94->67|95->68|100->73|100->73|100->73|102->75|102->75|103->76
                  -- GENERATED --
              */
          