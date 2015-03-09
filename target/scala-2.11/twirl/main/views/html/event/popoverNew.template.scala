
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
object popoverNew extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div id="popoverNew" class="hide">
    <form class="form-horizontal formNew" role="form" method="post" action=""""),_display_(/*2.78*/routes/*2.84*/.Events.addAndEdit()),format.raw/*2.104*/("""">
        <div class="form-group" >
            <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*4.69*/Messages("lbl.name")),format.raw/*4.89*/("""</label>
            <div class="col-sm-10">
                <input name="name" class="form-control inputNewEvent" placeholder="Výročie aqaparku" required autocomplete="off"
                data-bind="value: event().name">
            </div>

        </div>

        <div class="form-group" >
            <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*13.69*/Messages("lbl.eventType")),format.raw/*13.94*/("""</label>
            <div class="col-sm-10">
                <select name="eventType" class="form-control"  data-bind="value: event().eventType" required>
                """),_display_(/*16.18*/for(eType <- dto.EventType.values()) yield /*16.54*/ {_display_(Seq[Any](format.raw/*16.56*/("""
                    """),format.raw/*17.21*/("""<option value=""""),_display_(/*17.37*/eType),format.raw/*17.42*/("""">"""),_display_(/*17.45*/Messages(eType.toString())),format.raw/*17.71*/("""</option>
                """)))}),format.raw/*18.18*/("""
                """),format.raw/*19.17*/("""</select>
            </div>
        </div>

        <div class="form-group" data-bind="attr: """),format.raw/*23.50*/("""{"""),format.raw/*23.51*/(""" """),format.raw/*23.52*/("""class: event().eventType() === 'INSTALLATION' ? 'form-group' : 'form-group hide' """),format.raw/*23.133*/("""}"""),format.raw/*23.134*/("""" >
            <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*24.69*/Messages("lbl.assignedAction")),format.raw/*24.99*/("""</label>
            <div class="col-sm-10">
                <select name="assignedAction" class="form-control" required>
                """),_display_(/*27.18*/for(eType <- dto.EventType.values()) yield /*27.54*/ {_display_(Seq[Any](format.raw/*27.56*/("""
                    """),format.raw/*28.21*/("""<option value=""""),_display_(/*28.37*/eType),format.raw/*28.42*/("""">"""),_display_(/*28.45*/Messages(eType.toString())),format.raw/*28.71*/("""</option>
                """)))}),format.raw/*29.18*/("""
                """),format.raw/*30.17*/("""</select>
            </div>
        </div>

        <input name="start" type="hidden" data-bind="value: event().start">
        <input name="end" type="hidden" data-bind="value: event().end">
        <input name="allDay" type="hidden" data-bind="value: event().allDay">

        <div class="form-group" >
            <div class="col-sm-10 col-sm-offset-2">
                <input class="btn btn-sm btn-primary" onclick="submitClicked=this.name" name="addEvent" type="submit" value='"""),_display_(/*40.127*/Messages("btn.addEvent")),format.raw/*40.151*/("""'>
                    &nbsp;
                <input class="btn btn-sm btn-link" onclick="submitClicked=this.name" name="addEventAndEdit" type="submit" value='"""),_display_(/*42.131*/Messages("btn.addEventAndEdit")),format.raw/*42.162*/("""' >
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
                  DATE: Mon Mar 09 21:53:21 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/popoverNew.scala.html
                  HASH: ec8bd144dcdd5e6838c18e3cd7fc5fdb2e005ffe
                  MATRIX: 809->0|948->113|962->119|1003->139|1136->246|1176->266|1573->636|1619->661|1821->836|1873->872|1913->874|1963->896|2006->912|2032->917|2062->920|2109->946|2168->974|2214->992|2340->1090|2369->1091|2398->1092|2508->1173|2538->1174|2638->1247|2689->1277|2858->1419|2910->1455|2950->1457|3000->1479|3043->1495|3069->1500|3099->1503|3146->1529|3205->1557|3251->1575|3773->2069|3819->2093|4009->2255|4062->2286
                  LINES: 29->1|30->2|30->2|30->2|32->4|32->4|41->13|41->13|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|46->18|47->19|51->23|51->23|51->23|51->23|51->23|52->24|52->24|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|57->29|58->30|68->40|68->40|70->42|70->42
                  -- GENERATED --
              */
          