function initKlostIS(){

    initTooltips();
    setAvailTableHeightStoreman();
    setScrollspyOffset(140);
    addEvent(window, "resize", setAvailTableHeightStoreman);
    showGritterNotification();

}