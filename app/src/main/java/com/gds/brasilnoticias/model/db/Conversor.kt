package com.gds.brasilnoticias.model.db

import androidx.room.TypeConverter
import com.gds.brasilnoticias.model.Fonte

class Conversor {
    @TypeConverter
    fun fromSource(fonte: Fonte) : String{
        return fonte.name
    }
    @TypeConverter
    fun toSource(name : String) : Fonte{
        return Fonte(name,name)
    }

}