
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
object formEvent extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,String,Boolean,Form[dto.EventTO],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventType: String, eventId: String, allDay: Boolean, eventForm: Form[dto.EventTO]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.85*/("""

"""),format.raw/*3.1*/("""<div class="form-group" id="eventId" data-eventId=""""),_display_(/*3.53*/eventId),format.raw/*3.60*/("""" data-eventType=""""),_display_(/*3.79*/eventType),format.raw/*3.88*/("""" data-allDay=""""),_display_(/*3.104*/allDay),format.raw/*3.110*/("""">
    <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*4.61*/Messages("lbl.name")),format.raw/*4.81*/("""</label>

    <div class="col-sm-7">
        <input name="name" class="form-control" autocomplete="off" required value='"""),_display_(/*7.85*/eventForm/*7.94*/.field("name").value),format.raw/*7.114*/("""'>
    </div>
</div>

<div class="form-group">
    <div class="checkbox">
        <label class="col-sm-offset-2">
            <input name="allDay" type="checkbox" class="ace"
            data-bind="checked: event().allDay" """),_display_(/*15.50*/if(eventForm.field("allDay").value.equals("true"))/*15.100*/ {_display_(Seq[Any](format.raw/*15.102*/("""checked""")))}),format.raw/*15.110*/(""" """),format.raw/*15.111*/(""">
            <span class="lbl"> """),_display_(/*16.33*/Messages("lbl.allDay")),format.raw/*16.55*/("""</span>
        </label>
    </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*22.61*/Messages("lbl.start")),format.raw/*22.82*/("""</label>

    <div class="col-sm-3">
        <input type="date" required class="form-control" name="startDate" value='"""),_display_(/*25.83*/eventForm/*25.92*/.field("startDate").value),format.raw/*25.117*/("""'>
    </div>

    <div class="col-sm-2">
        <input data-bind="attr: """),format.raw/*29.33*/("""{"""),format.raw/*29.34*/(""" """),format.raw/*29.35*/("""class: event().allDay() ? 'form-control hide' : 'form-control' """),format.raw/*29.98*/("""}"""),format.raw/*29.99*/(""""
        class="form-control" required type="time" name="startTime" value='"""),_display_(/*30.76*/eventForm/*30.85*/.field("startTime").value),format.raw/*30.110*/("""'>
    </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*35.61*/Messages("lbl.end")),format.raw/*35.80*/("""</label>

    <div class="col-sm-3">
        <input type="date" required class="form-control" name="endDate" value='"""),_display_(/*38.81*/eventForm/*38.90*/.field("endDate").value),format.raw/*38.113*/("""'>
    </div>

    <div class="col-sm-2">
        <input data-bind="attr: """),format.raw/*42.33*/("""{"""),format.raw/*42.34*/(""" """),format.raw/*42.35*/("""class: event().allDay() ? 'form-control hide' : 'form-control' """),format.raw/*42.98*/("""}"""),format.raw/*42.99*/(""""
        required type="time" name="endTime" value='"""),_display_(/*43.53*/eventForm/*43.62*/.field("endTime").value),format.raw/*43.85*/("""'>
    </div>
</div>"""))}
  }

  def render(eventType:String,eventId:String,allDay:Boolean,eventForm:Form[dto.EventTO]): play.twirl.api.HtmlFormat.Appendable = apply(eventType,eventId,allDay,eventForm)

  def f:((String,String,Boolean,Form[dto.EventTO]) => play.twirl.api.HtmlFormat.Appendable) = (eventType,eventId,allDay,eventForm) => apply(eventType,eventId,allDay,eventForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Mar 11 23:40:20 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/formEvent.scala.html
                  HASH: d3ec09ce665e6cbda4b08a46ab962fff63ad5381
                  MATRIX: 766->1|937->84|967->88|1045->140|1072->147|1117->166|1146->175|1189->191|1216->197|1306->261|1346->281|1496->405|1513->414|1554->434|1813->666|1873->716|1914->718|1954->726|1984->727|2046->762|2089->784|2251->919|2293->940|2442->1062|2460->1071|2507->1096|2613->1174|2642->1175|2671->1176|2762->1239|2791->1240|2896->1318|2914->1327|2961->1352|3100->1464|3140->1483|3287->1603|3305->1612|3350->1635|3456->1713|3485->1714|3514->1715|3605->1778|3634->1779|3716->1834|3734->1843|3778->1866
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|32->4|32->4|35->7|35->7|35->7|43->15|43->15|43->15|43->15|43->15|44->16|44->16|50->22|50->22|53->25|53->25|53->25|57->29|57->29|57->29|57->29|57->29|58->30|58->30|58->30|63->35|63->35|66->38|66->38|66->38|70->42|70->42|70->42|70->42|70->42|71->43|71->43|71->43
                  -- GENERATED --
              */
          