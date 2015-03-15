
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
object popoverClick extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div id="popoverClick" class="hide">
    <form class="form-horizontal" role="form">

        <div class="form-group" data-bind="attr: """),format.raw/*4.50*/("""{"""),format.raw/*4.51*/(""" """),format.raw/*4.52*/("""class: event().isDownloadDocBtnVisible() ? 'form-group' : 'form-group hide' """),format.raw/*4.128*/("""}"""),format.raw/*4.129*/("""">
            <div class="col-sm-6">
                <a class="btn btn-white btn-inverse btnPopover" onclick="removePopovers ( )"
                href data-bind="attr: """),format.raw/*7.39*/("""{"""),format.raw/*7.40*/(""" """),format.raw/*7.41*/("""href: '/priceOffer/' + event().eventType() + '/' + event().id() """),format.raw/*7.105*/("""}"""),format.raw/*7.106*/("""">
                    <i class="ace-icon fa fa-file bigger-110"></i>
                    """),_display_(/*9.22*/Messages("btn.priceOffer")),format.raw/*9.48*/("""
                """),format.raw/*10.17*/("""</a>
            </div>
            <div class="col-sm-6" data-bind="attr: """),format.raw/*12.52*/("""{"""),format.raw/*12.53*/(""" """),format.raw/*12.54*/("""class: event().isChangeCalBtnVisible() ? 'col-sm-6' : 'col-sm-6 hide' """),format.raw/*12.124*/("""}"""),format.raw/*12.125*/("""" >
                <a class="btn btn-white btn-inverse btnPopover" type="submit" data-bind="click: changeCal">
                    <i class="ace-icon fa fa-calendar-o bigger-110"></i>
                        <!--ko text: event().changeCalText--><!--/ko-->
                </a>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-6">
                <a class="btn btn-sm btn-danger btnPopover" data-bind="click: modalDelete">
                    <i class="ace-icon fa fa-trash-o bigger-110"></i>
                    """),_display_(/*24.22*/Messages("btn.delete")),format.raw/*24.44*/("""
                """),format.raw/*25.17*/("""</a>
            </div>
            <div class="col-sm-6">
                <a class="btn btn-sm btn-info btnPopover" href data-bind="attr: """),format.raw/*28.81*/("""{"""),format.raw/*28.82*/(""" """),format.raw/*28.83*/("""href: '/event/' + event().eventType() + '/' + event().id() """),format.raw/*28.142*/("""}"""),format.raw/*28.143*/("""">
                    <i class="ace-icon fa fa-pencil bigger-110"></i>
                    """),_display_(/*30.22*/Messages("btn.edit")),format.raw/*30.42*/("""
                """),format.raw/*31.17*/("""</a>
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
                  DATE: Sun Mar 15 16:41:30 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/popoverClick.scala.html
                  HASH: 3a30ecc7e57b859689cb69713ee4635365fd0379
                  MATRIX: 811->0|975->137|1003->138|1031->139|1135->215|1164->216|1363->388|1391->389|1419->390|1511->454|1540->455|1659->548|1705->574|1751->592|1856->669|1885->670|1914->671|2013->741|2043->742|2646->1318|2689->1340|2735->1358|2905->1500|2934->1501|2963->1502|3051->1561|3081->1562|3203->1657|3244->1677|3290->1695
                  LINES: 29->1|32->4|32->4|32->4|32->4|32->4|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|40->12|40->12|40->12|40->12|40->12|52->24|52->24|53->25|56->28|56->28|56->28|56->28|56->28|58->30|58->30|59->31
                  -- GENERATED --
              */
          