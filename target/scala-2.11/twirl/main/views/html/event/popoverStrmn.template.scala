
package views.html.event

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
object popoverStrmn extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div id="popoverStrmn" class="hide">
    <form class="form-horizontal" role="form">

        <div class="form-group" >
            <div class="col-sm-6" data-bind="attr: """),format.raw/*5.52*/("""{"""),format.raw/*5.53*/(""" """),format.raw/*5.54*/("""class: event().isDownloadDocBtnVisible() ? 'col-sm-6' : 'col-sm-6 hide' """),format.raw/*5.126*/("""}"""),format.raw/*5.127*/("""">
                <a class="btn btn-white btn-inverse btnPopover" onclick="removePopovers ( )"
                href data-bind="attr: """),format.raw/*7.39*/("""{"""),format.raw/*7.40*/(""" """),format.raw/*7.41*/("""href: '/contract/' + event().eventType() + '/' + event().id() """),format.raw/*7.103*/("""}"""),format.raw/*7.104*/("""">
                    <i class="ace-icon fa fa-file bigger-110"></i>
                    <!--ko text: event().downloadDocText--><!--/ko-->
                </a>
            </div>

            <div class="col-sm-6">
                <a class="btn btn-sm btn-info btnPopover" href data-bind="attr: """),format.raw/*14.81*/("""{"""),format.raw/*14.82*/(""" """),format.raw/*14.83*/("""href: '/event/storeman/' + event().eventType() + '/' + event().id() """),format.raw/*14.151*/("""}"""),format.raw/*14.152*/("""">
                    <i class="ace-icon fa fa-pencil bigger-110"></i>
                    """),_display_(/*16.22*/Messages("btn.edit")),format.raw/*16.42*/("""
                """),format.raw/*17.17*/("""</a>
            </div>
        </div>

    </form>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 16:58:07 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/popoverStrmn.scala.html
                  HASH: 2b9e27b27063607afe746f66e3e5c03dda9c0ff1
                  MATRIX: 811->0|1012->174|1040->175|1068->176|1168->248|1197->249|1360->385|1388->386|1416->387|1506->449|1535->450|1866->753|1895->754|1924->755|2021->823|2051->824|2173->919|2214->939|2260->957
                  LINES: 29->1|33->5|33->5|33->5|33->5|33->5|35->7|35->7|35->7|35->7|35->7|42->14|42->14|42->14|42->14|42->14|44->16|44->16|45->17
                  -- GENERATED --
              */
          