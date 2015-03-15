
package views.html.tent

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
object neu extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/views/*1.7*/.html.master.main(Messages("nav.tents"))/*1.47*/(2)/*1.50*/ {_display_(Seq[Any](format.raw/*1.52*/("""
""")))}/*2.2*/ {_display_(Seq[Any](format.raw/*2.4*/("""
    """),format.raw/*3.5*/("""<div class="page-header">
        <h1>
        """),_display_(/*5.10*/Messages("h.newTent")),format.raw/*5.31*/("""
        """),format.raw/*6.9*/("""</h1>
    </div>

    <div class="row">
        <div class="col-xs-12">

        """),_display_(/*12.10*/helper/*12.16*/.form(action = routes.Tents.add(), 'class -> "form-horizontal", 'role -> "form", 'id -> "form")/*12.111*/ {_display_(Seq[Any](format.raw/*12.113*/("""

            """),_display_(/*14.14*/views/*14.19*/.html.tent.form(0l)),format.raw/*14.38*/("""

            """),format.raw/*16.13*/("""<div class="clearfix form-actions">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary">"""),_display_(/*18.68*/Messages("btn.addTent")),format.raw/*18.91*/("""</button>
                        &nbsp;
                    <a class="btn" type="reset" href=""""),_display_(/*20.56*/routes/*20.62*/.Tents.list),format.raw/*20.73*/("""">"""),_display_(/*20.76*/Messages("btn.back")),format.raw/*20.96*/("""</a>
                </div>
            </div>
        """)))}),format.raw/*23.10*/("""

        """),format.raw/*25.9*/("""</div>
    </div>
""")))}/*27.2*/ {_display_(Seq[Any](format.raw/*27.4*/("""
    """),format.raw/*28.5*/("""<script src='"""),_display_(/*28.19*/routes/*28.25*/.Assets.at("js/tentCommon.js")),format.raw/*28.55*/("""'></script>
    <script src='"""),_display_(/*29.19*/routes/*29.25*/.Assets.at("js/tentNew.js")),format.raw/*29.52*/("""'></script>
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 19:57:55 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/tent/neu.scala.html
                  HASH: 304c51f768092f7532687d7cf99e2729fc7a9827
                  MATRIX: 801->1|813->6|861->46|872->49|911->51|931->54|969->56|1001->62|1077->112|1118->133|1154->143|1269->231|1284->237|1389->332|1430->334|1474->351|1488->356|1528->375|1572->391|1744->536|1788->559|1913->657|1928->663|1960->674|1990->677|2031->697|2121->756|2160->768|2199->789|2238->791|2271->797|2312->811|2327->817|2378->847|2436->878|2451->884|2499->911
                  LINES: 29->1|29->1|29->1|29->1|29->1|30->2|30->2|31->3|33->5|33->5|34->6|40->12|40->12|40->12|40->12|42->14|42->14|42->14|44->16|46->18|46->18|48->20|48->20|48->20|48->20|48->20|51->23|53->25|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29
                  -- GENERATED --
              */
          