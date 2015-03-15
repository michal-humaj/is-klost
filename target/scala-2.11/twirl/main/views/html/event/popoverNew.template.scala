
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
                <select name="eventType" class="form-control" data-bind="value: event().eventType" required>
                """),_display_(/*16.18*/for(eType <- dto.EventType.values()) yield /*16.54*/ {_display_(Seq[Any](format.raw/*16.56*/("""
                    """),format.raw/*17.21*/("""<option value=""""),_display_(/*17.37*/eType),format.raw/*17.42*/("""">"""),_display_(/*17.45*/Messages(eType.toString())),format.raw/*17.71*/("""</option>
                """)))}),format.raw/*18.18*/("""
                """),format.raw/*19.17*/("""</select>
            </div>
        </div>

        <div class="form-group" data-bind="attr: """),format.raw/*23.50*/("""{"""),format.raw/*23.51*/(""" """),format.raw/*23.52*/("""class: event().eventType() === 'INSTALLATION' ? 'form-group' : 'form-group hide' """),format.raw/*23.133*/("""}"""),format.raw/*23.134*/("""" >
            <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*24.69*/Messages("lbl.assignedAction")),format.raw/*24.99*/("""</label>
            <div class="col-sm-10">
                <select name="actionId" class="form-control" data-bind="foreach: upcomingActions, value: event().actionId">
                    <option data-bind="text: name, attr: """),format.raw/*27.58*/("""{"""),format.raw/*27.59*/("""value: id"""),format.raw/*27.68*/("""}"""),format.raw/*27.69*/(""""></option>
                </select>
            </div>
        </div>

        <input name="start" type="hidden" data-bind="value: event().start">
        <input name="end" type="hidden" data-bind="value: event().end">
        <input name="allDay" type="hidden" data-bind="value: event().allDay">

        <div class="form-group" >
            <div class="col-sm-10 col-sm-offset-2">
                <input class="btn btn-sm btn-primary" onclick="submitClicked = this.name" name="addEvent" type="submit" value='"""),_display_(/*38.129*/Messages("btn.addEvent")),format.raw/*38.153*/("""'>
                    &nbsp;
                <input data-bind="attr: """),format.raw/*40.41*/("""{"""),format.raw/*40.42*/(""" """),format.raw/*40.43*/("""class: event().eventType() === 'INSTALLATION' ? 'btn btn-sm btn-link hide' : 'btn btn-sm btn-link' """),format.raw/*40.142*/("""}"""),format.raw/*40.143*/(""""
                class="btn btn-sm btn-link" onclick="submitClicked = this.name" name="addEventAndEdit" type="submit" value='"""),_display_(/*41.126*/Messages("btn.addEventAndEdit")),format.raw/*41.157*/("""' >
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
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/popoverNew.scala.html
                  HASH: 975de00c387e392b3edc4d8fe98576c9b8cda857
                  MATRIX: 809->0|948->113|962->119|1003->139|1136->246|1176->266|1573->636|1619->661|1820->835|1872->871|1912->873|1962->895|2005->911|2031->916|2061->919|2108->945|2167->973|2213->991|2339->1089|2368->1090|2397->1091|2507->1172|2537->1173|2637->1246|2688->1276|2945->1505|2974->1506|3011->1515|3040->1516|3593->2041|3639->2065|3739->2137|3768->2138|3797->2139|3925->2238|3955->2239|4111->2367|4164->2398
                  LINES: 29->1|30->2|30->2|30->2|32->4|32->4|41->13|41->13|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|46->18|47->19|51->23|51->23|51->23|51->23|51->23|52->24|52->24|55->27|55->27|55->27|55->27|66->38|66->38|68->40|68->40|68->40|68->40|68->40|69->41|69->41
                  -- GENERATED --
              */
          