
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
object neuFromTemplate extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Long,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tentId : Long):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.17*/("""

"""),_display_(/*3.2*/views/*3.7*/.html.master.main(Messages("h.editTent"))/*3.48*/(2)/*3.51*/ {_display_(Seq[Any](format.raw/*3.53*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
    """),format.raw/*5.5*/("""<div class="page-header">
        <h1>Vyvtvorit nový stan na základe existujuceho

        </h1>
    </div>

    <div class="row">
        <div class="col-xs-12">

        """),_display_(/*14.10*/helper/*14.16*/.form(action = routes.Tents.add(), 'class -> "form-horizontal", 'role -> "form", 'id -> "form")/*14.111*/ {_display_(Seq[Any](format.raw/*14.113*/("""

            """),_display_(/*16.14*/views/*16.19*/.html.tent.form(tentId)),format.raw/*16.42*/("""

            """),format.raw/*18.13*/("""<div class="clearfix form-actions">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary">"""),_display_(/*20.68*/Messages("btn.add")),format.raw/*20.87*/("""</button>
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
                  DATE: Fri Mar 20 13:13:41 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/tent/neuFromTemplate.scala.html
                  HASH: 988ad6aa052f940f89a9f077d46d22630c2d56ed
                  MATRIX: 736->1|839->16|869->21|881->26|930->67|941->70|980->72|1000->75|1038->77|1070->83|1279->265|1294->271|1399->366|1440->368|1484->385|1498->390|1542->413|1586->429|1758->574|1798->593|1923->691|1938->697|1970->708|2000->711|2041->731|2131->790|2170->802|2209->823|2248->825|2281->831|2322->845|2337->851|2388->881|2446->912|2461->918|2510->946
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|33->5|42->14|42->14|42->14|42->14|44->16|44->16|44->16|46->18|48->20|48->20|50->22|50->22|50->22|50->22|50->22|53->25|55->27|57->29|57->29|58->30|58->30|58->30|58->30|59->31|59->31|59->31
                  -- GENERATED --
              */
          