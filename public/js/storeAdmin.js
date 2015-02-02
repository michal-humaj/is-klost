function initKlostIS(){

    initDatepicker();
    initTooltips();
    setAvailTableHeightAdmin();
    setListenerCollapseEventsWidget();
    setScrollspyOffset(140);
    addEvent(window, "resize", setAvailTableHeightAdmin);
    showGritterNotification();

}