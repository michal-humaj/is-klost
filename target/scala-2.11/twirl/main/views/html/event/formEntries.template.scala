
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
object formEntries extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<h4 class="col-sm-offset-2 header blue lighter smaller">"""),_display_(/*1.58*/Messages("h.eventItems")),format.raw/*1.82*/("""</h4>

<div data-bind="foreach: entries">
    <div class="form-group" data-bind="attr: """),format.raw/*4.46*/("""{"""),format.raw/*4.47*/(""" """),format.raw/*4.48*/("""class: itemName.isValid() ? 'form-group' : 'form-group has-info' """),format.raw/*4.113*/("""}"""),format.raw/*4.114*/("""">
        <div class="col-sm-offset-2 col-sm-7">
            <input class="form-control autocomplete" placeholder="Stolička plastová"
                   data-bind="value: itemName, valueUpdate: 'blur' ">
        </div>

        <input type="hidden" data-bind="attr: """),format.raw/*10.47*/("""{"""),format.raw/*10.48*/(""" """),format.raw/*10.49*/("""name: fieldItem """),format.raw/*10.65*/("""}"""),format.raw/*10.66*/(""", value: $root.itemIdMap()[itemName()] " >

        <div class="col-sm-2">
            <input class="form-control" placeholder="18" autocomplete="off" required type="number"
                   data-bind="attr: """),format.raw/*14.37*/("""{"""),format.raw/*14.38*/(""" """),format.raw/*14.39*/("""name: fieldAmount, min: amountMinAndStep, step: amountMinAndStep"""),format.raw/*14.103*/("""}"""),format.raw/*14.104*/(""", value: amount ">
        </div>

        <div class="col-sm-1">
            <a type="button" class="btn btn-white btn-danger" data-bind="click: $parent.removeEntry">
                <span class="fa fa-times"></span>
            </a>
        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-sm-offset-11 col-sm-1">
        <a type="button" class="btn btn-primary btn-sm" data-bind="click: addEntry">
            <span class="fa fa-plus "></span>
        </a>
    </div>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Mar 20 13:13:41 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/formEntries.scala.html
                  HASH: d4ace93e09f71957f4b9a96e1681ae53bce9e54b
                  MATRIX: 810->0|893->57|937->81|1054->171|1082->172|1110->173|1203->238|1232->239|1533->512|1562->513|1591->514|1635->530|1664->531|1906->745|1935->746|1964->747|2057->811|2087->812
                  LINES: 29->1|29->1|29->1|32->4|32->4|32->4|32->4|32->4|38->10|38->10|38->10|38->10|38->10|42->14|42->14|42->14|42->14|42->14
                  -- GENERATED --
              */
          