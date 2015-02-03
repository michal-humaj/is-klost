function initKlostIS(){

    initDatepicker();
    initTooltips();
    setAvailTableHeightAdmin();
    setAvailTableHeightOnCollapseEventsWidget();
    setScrollspyOffset(140);
    addEvent(window, "resize", setAvailTableHeightAdmin);
    showGritterNotification();

}