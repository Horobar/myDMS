package myoffice.dms

import myoffice.dms.config.DmsCommonProperties
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component


class PropertyDemoComponent(
    private val dmsCommonProperties: DmsCommonProperties
) {
    @EventListener(ApplicationReadyEvent::class)
    fun onStartUp(){
        println(dmsCommonProperties.home)
    }
}