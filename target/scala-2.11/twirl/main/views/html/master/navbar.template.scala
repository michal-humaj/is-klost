
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

                <li class='"""),_display_(/*26.29*/if(tabNumber.equals(0))/*26.52*/ {}/*26.56*/else/*26.61*/{_display_(Seq[Any](format.raw/*26.62*/("""transparent""")))}),format.raw/*26.74*/("""'>
                    <a href='"""),_display_(/*27.31*/routes/*27.37*/.App.calendar("TODAY")),format.raw/*27.59*/("""'>
                        <i class="ace-icon fa fa-calendar-o"></i>
                        """),_display_(/*29.26*/Messages("nav.cal")),format.raw/*29.45*/("""
                    """),format.raw/*30.21*/("""</a>
                </li>

                <li class='"""),_display_(/*33.29*/if(tabNumber.equals(1))/*33.52*/ {}/*33.56*/else/*33.61*/{_display_(Seq[Any](format.raw/*33.62*/("""transparent""")))}),format.raw/*33.74*/("""'>
                    <a href='"""),_display_(/*34.31*/routes/*34.37*/.App.store("TOMORROW")),format.raw/*34.59*/("""'>
                        <i class="ace-icon fa fa-cubes"></i>
                        """),_display_(/*36.26*/Messages("nav.store")),format.raw/*36.47*/("""
                    """),format.raw/*37.21*/("""</a>
                </li>
                """),_display_(/*39.18*/currentAuth()/*39.31*/ { auth =>_display_(Seq[Any](format.raw/*39.41*/("""
                    """),_display_(/*40.22*/if(LoggedAdmin.isAdminId(auth.getId()))/*40.61*/{_display_(Seq[Any](format.raw/*40.62*/("""
                        """),format.raw/*41.25*/("""<li class='"""),_display_(/*41.37*/if(tabNumber.equals(2))/*41.60*/ {}/*41.64*/else/*41.69*/{_display_(Seq[Any](format.raw/*41.70*/("""transparent""")))}),format.raw/*41.82*/("""'>
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
                  DATE: Wed Mar 11 23:40:20 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/master/navbar.scala.html
                  HASH: 162322595e246c97affa2816a3233dd1d66dd473
                  MATRIX: 728->1|875->17|905->67|933->69|1564->673|1579->679|1627->706|1858->910|1890->933|1902->937|1915->942|1954->943|1997->955|2058->989|2073->995|2116->1017|2239->1113|2279->1132|2329->1154|2415->1213|2447->1236|2459->1240|2472->1245|2511->1246|2554->1258|2615->1292|2630->1298|2673->1320|2791->1411|2833->1432|2883->1454|2956->1500|2978->1513|3026->1523|3076->1546|3124->1585|3163->1586|3217->1612|3256->1624|3288->1647|3300->1651|3313->1656|3352->1657|3395->1669|3464->1711|3479->1717|3513->1730|3587->1777|3602->1783|3649->1809|3736->1869|3778->1890|3836->1920|3925->1978|3975->1997|4017->2011|4369->2336|4385->2343|4421->2358|4600->2510|4622->2523|4670->2533|4732->2568|4780->2607|4819->2608|4885->2647|4927->2668|4981->2703|4994->2707|5033->2708|5099->2747|5144->2771|5210->2806|5272->2837|5330->2867|5396->2906|5412->2913|5449->2929|5503->2955|5809->3234|5821->3237|5902->3296|6040->3407|6083->3429|6141->3459
                  LINES: 26->1|29->1|31->4|32->5|45->18|45->18|45->18|53->26|53->26|53->26|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|57->30|60->33|60->33|60->33|60->33|60->33|60->33|61->34|61->34|61->34|63->36|63->36|64->37|66->39|66->39|66->39|67->40|67->40|67->40|68->41|68->41|68->41|68->41|68->41|68->41|68->41|69->42|69->42|69->42|70->43|70->43|70->43|71->44|71->44|72->45|74->47|75->48|76->49|83->56|83->56|83->56|86->59|86->59|86->59|87->60|87->60|87->60|88->61|88->61|89->62|89->62|89->62|90->63|90->63|91->64|92->65|93->66|94->67|94->67|94->67|95->68|100->73|100->73|100->73|102->75|102->75|103->76
                  -- GENERATED --
              */
          