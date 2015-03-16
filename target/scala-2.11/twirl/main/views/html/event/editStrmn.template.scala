
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
object editStrmn extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,String,Boolean,Form[dto.EventTO],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventType: String, eventId: String, allDay: Boolean, eventForm: Form[dto.EventTO], returnDate: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.105*/("""

"""),_display_(/*3.2*/views/*3.7*/.html.master.main(Messages("h.editEvent"))/*3.49*/(0)/*3.52*/ {_display_(Seq[Any](format.raw/*3.54*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
    """),format.raw/*5.5*/("""<div class="page-header">
        <h1>
        """),_display_(/*7.10*/eventForm/*7.19*/.field("name").value),format.raw/*7.39*/("""
        """),format.raw/*8.9*/("""</h1>
    </div>

    <div class="row">
        <div class="col-xs-12" id="eventId" data-eventId=""""),_display_(/*12.60*/eventId),format.raw/*12.67*/("""" data-eventType=""""),_display_(/*12.86*/eventType),format.raw/*12.95*/("""" data-allDay=""""),_display_(/*12.111*/allDay),format.raw/*12.117*/("""">

            """),_display_(/*14.14*/if(flash.containsKey("error"))/*14.44*/ {_display_(Seq[Any](format.raw/*14.46*/("""
                """),format.raw/*15.17*/("""<div class="alert alert-danger">
                """),_display_(/*16.18*/flash/*16.23*/.get("error")),format.raw/*16.36*/("""
                """),format.raw/*17.17*/("""</div>
            """)))}),format.raw/*18.14*/("""

            """),_display_(/*20.14*/helper/*20.20*/.form(action = routes.Events.updateStrmn(eventType, eventId), 'class -> "form-horizontal", 'role -> "form", 'id -> "form")/*20.142*/ {_display_(Seq[Any](format.raw/*20.144*/("""
                """),format.raw/*21.17*/("""<div class="widget-box transparent light-border">
                    <div class="widget-header widget-header-flat">
                        <h4 class="widget-title ">"""),_display_(/*23.52*/Messages("h.eventItems")),format.raw/*23.76*/("""</h4>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main no-padding">
                            <table class="table ">
                                <tbody data-bind="foreach: nonCarpetEntries">
                                    <tr>
                                        <td data-bind="text: itemName"></td>
                                        <td data-bind="text: amount"></td>
                                        <input type="hidden" data-bind="attr: """),format.raw/*32.79*/("""{"""),format.raw/*32.80*/(""" """),format.raw/*32.81*/("""name: fieldItem """),format.raw/*32.97*/("""}"""),format.raw/*32.98*/(""", value: $root.itemIdMap()[itemName()] " >
                                        <input type="hidden" data-bind="attr: """),format.raw/*33.79*/("""{"""),format.raw/*33.80*/(""" """),format.raw/*33.81*/("""name: fieldAmount """),format.raw/*33.99*/("""}"""),format.raw/*33.100*/(""", value: amount " >
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="space"></div>

                <h4 class="header blue lighter smaller">"""),_display_(/*42.58*/Messages("h.eventCarpets")),format.raw/*42.84*/("""</h4>
                <div data-bind="foreach: carpetEntries">
                    <div class="form-group" data-bind="attr: """),format.raw/*44.62*/("""{"""),format.raw/*44.63*/(""" """),format.raw/*44.64*/("""class: itemName.isValid() ? 'form-group' : 'form-group has-info' """),format.raw/*44.129*/("""}"""),format.raw/*44.130*/("""">
                        <div class="col-sm-7">
                            <input class="form-control autocomplete" placeholder="Ultrasil tmavý"
                            data-bind="value: itemName, valueUpdate: 'blur' ">
                        </div>

                        <input type="hidden" data-bind="attr: """),format.raw/*50.63*/("""{"""),format.raw/*50.64*/(""" """),format.raw/*50.65*/("""name: fieldItem """),format.raw/*50.81*/("""}"""),format.raw/*50.82*/(""", value: $root.itemIdMap()[itemName()] " >

                        <div class="col-sm-2">
                            <input class="form-control" placeholder="12.3" autocomplete="off" required type="number"
                            data-bind="attr: """),format.raw/*54.46*/("""{"""),format.raw/*54.47*/(""" """),format.raw/*54.48*/("""name: fieldAmount, min: amountMinAndStep, step: amountMinAndStep"""),format.raw/*54.112*/("""}"""),format.raw/*54.113*/(""", value: amount ">
                        </div>

                        <div class="col-sm-1">
                            <a type="button" class="btn btn-white btn-danger" data-bind="click: $parent.removeEntry">
                                <span class="fa fa-times"></span>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-9 col-sm-1">
                        <a type="button" class="btn btn-primary btn-sm" data-bind="click: addEntry">
                            <span class="fa fa-plus "></span>
                        </a>
                    </div>
                </div>

                <div class="clearfix form-actions">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">"""),_display_(/*75.72*/Messages("btn.update")),format.raw/*75.94*/("""</button>
                            &nbsp;
                        <a class="btn" type="reset" href='"""),_display_(/*77.60*/routes/*77.66*/.App.calendar(returnDate)),format.raw/*77.91*/("""'>"""),_display_(/*77.94*/Messages("btn.back")),format.raw/*77.114*/("""</a>
                    </div>
                </div>
            """)))}),format.raw/*80.14*/("""

        """),format.raw/*82.9*/("""</div>
    </div>
""")))}/*84.2*/ {_display_(Seq[Any](format.raw/*84.4*/("""
    """),format.raw/*85.5*/("""<script src='"""),_display_(/*85.19*/routes/*85.25*/.Assets.at("js/eventEditCommon.js")),format.raw/*85.60*/("""'></script>
    <script src='"""),_display_(/*86.19*/routes/*86.25*/.Assets.at("js/eventEditStrmn.js")),format.raw/*86.59*/("""'></script>
""")))}))}
  }

  def render(eventType:String,eventId:String,allDay:Boolean,eventForm:Form[dto.EventTO],returnDate:String): play.twirl.api.HtmlFormat.Appendable = apply(eventType,eventId,allDay,eventForm,returnDate)

  def f:((String,String,Boolean,Form[dto.EventTO],String) => play.twirl.api.HtmlFormat.Appendable) = (eventType,eventId,allDay,eventForm,returnDate) => apply(eventType,eventId,allDay,eventForm,returnDate)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 19:57:54 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/editStrmn.scala.html
                  HASH: 6d78e3c905cb9f26007022008d30140ff6118970
                  MATRIX: 773->1|965->104|995->109|1007->114|1057->156|1068->159|1107->161|1127->164|1165->166|1197->172|1273->222|1290->231|1330->251|1366->261|1496->364|1524->371|1570->390|1600->399|1644->415|1672->421|1718->440|1757->470|1797->472|1843->490|1921->541|1935->546|1969->559|2015->577|2067->598|2111->615|2126->621|2258->743|2299->745|2345->763|2542->933|2587->957|3164->1506|3193->1507|3222->1508|3266->1524|3295->1525|3445->1647|3474->1648|3503->1649|3549->1667|3579->1668|3936->1998|3983->2024|4137->2150|4166->2151|4195->2152|4289->2217|4319->2218|4674->2545|4703->2546|4732->2547|4776->2563|4805->2564|5090->2821|5119->2822|5148->2823|5241->2887|5271->2888|6226->3816|6269->3838|6402->3944|6417->3950|6463->3975|6493->3978|6535->3998|6637->4069|6676->4081|6715->4102|6754->4104|6787->4110|6828->4124|6843->4130|6899->4165|6957->4196|6972->4202|7027->4236
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|33->5|35->7|35->7|35->7|36->8|40->12|40->12|40->12|40->12|40->12|40->12|42->14|42->14|42->14|43->15|44->16|44->16|44->16|45->17|46->18|48->20|48->20|48->20|48->20|49->21|51->23|51->23|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|70->42|70->42|72->44|72->44|72->44|72->44|72->44|78->50|78->50|78->50|78->50|78->50|82->54|82->54|82->54|82->54|82->54|103->75|103->75|105->77|105->77|105->77|105->77|105->77|108->80|110->82|112->84|112->84|113->85|113->85|113->85|113->85|114->86|114->86|114->86
                  -- GENERATED --
              */
          