
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
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Long,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tentId : Long):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.17*/("""

"""),_display_(/*3.2*/views/*3.7*/.html.master.main(Messages("h.editTent"))/*3.48*/(2)/*3.51*/ {_display_(Seq[Any](format.raw/*3.53*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
    """),format.raw/*5.5*/("""<div class="page-header">
        <h1>
        """),_display_(/*7.10*/Messages("h.editTent")),format.raw/*7.32*/("""
        """),format.raw/*8.9*/("""</h1>
    </div>

    <div class="row">
        <div class="col-xs-12">

        """),_display_(/*14.10*/helper/*14.16*/.form(action = routes.Tents.update(tentId), 'class -> "form-horizontal", 'role -> "form", 'id -> "form")/*14.120*/ {_display_(Seq[Any](format.raw/*14.122*/("""

            """),_display_(/*16.14*/views/*16.19*/.html.tent.form(tentId)),format.raw/*16.42*/("""

            """),format.raw/*18.13*/("""<div class="clearfix form-actions">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary">"""),_display_(/*20.68*/Messages("btn.update")),format.raw/*20.90*/("""</button>
                        &nbsp;
                    <a class="btn" type="reset" href=""""),_display_(/*22.56*/routes/*22.62*/.Tents.list),format.raw/*22.73*/("""">"""),_display_(/*22.76*/Messages("btn.back")),format.raw/*22.96*/("""</a>
                </div>
            </div>
        """)))}),format.raw/*25.10*/("""

        """),format.raw/*27.9*/("""</div>
    </div>
""")))}/*29.2*/ {_display_(Seq[Any](format.raw/*29.4*/("""
    """),format.raw/*30.5*/("""<script src='"""),_display_(/*30.19*/routes/*30.25*/.Assets.at("js/tentCommon.js")),format.raw/*30.55*/("""'></script>
    <script src='"""),_display_(/*31.19*/routes/*31.25*/.Assets.at("js/tentEdit.js")),format.raw/*31.53*/("""'></script>
""")))}))}
  }

  def render(tentId:Long): play.twirl.api.HtmlFormat.Appendable = apply(tentId)

  def f:((Long) => play.twirl.api.HtmlFormat.Appendable) = (tentId) => apply(tentId)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 14 14:48:11 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/tent/edit.scala.html
                  HASH: 4a1f5f18e2d8016472f5e435d53a88ac6f6c3937
                  MATRIX: 725->1|828->16|858->21|870->26|919->67|930->70|969->72|989->75|1027->77|1059->83|1135->133|1177->155|1213->165|1328->253|1343->259|1457->363|1498->365|1542->382|1556->387|1600->410|1644->426|1816->571|1859->593|1984->691|1999->697|2031->708|2061->711|2102->731|2192->790|2231->802|2270->823|2309->825|2342->831|2383->845|2398->851|2449->881|2507->912|2522->918|2571->946
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|33->5|35->7|35->7|36->8|42->14|42->14|42->14|42->14|44->16|44->16|44->16|46->18|48->20|48->20|50->22|50->22|50->22|50->22|50->22|53->25|55->27|57->29|57->29|58->30|58->30|58->30|58->30|59->31|59->31|59->31
                  -- GENERATED --
              */
          