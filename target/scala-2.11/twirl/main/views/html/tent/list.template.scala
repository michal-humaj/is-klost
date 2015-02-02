
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
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/views/*1.7*/.html.master.main(Messages("nav.tents"))/*1.47*/(2)/*1.50*/{_display_(Seq[Any](format.raw/*1.51*/("""
""")))}/*2.2*/{_display_(Seq[Any](format.raw/*2.3*/("""
  """),format.raw/*3.3*/("""Stany
""")))}/*4.2*/{_display_(Seq[Any](format.raw/*4.3*/("""

""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Feb 02 11:30:58 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/tent/list.scala.html
                  HASH: 44e701d86828e8c8065aa26526dd7e7c9071034f
                  MATRIX: 802->1|814->6|862->46|873->49|911->50|930->52|967->53|996->56|1020->63|1057->64
                  LINES: 29->1|29->1|29->1|29->1|29->1|30->2|30->2|31->3|32->4|32->4
                  -- GENERATED --
              */
          