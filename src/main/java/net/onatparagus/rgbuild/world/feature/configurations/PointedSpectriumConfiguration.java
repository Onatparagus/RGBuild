package net.onatparagus.rgbuild.world.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;


public class PointedSpectriumConfiguration implements FeatureConfiguration {
    public static final Codec<PointedSpectriumConfiguration> CODEC = RecordCodecBuilder.create((p_191286_) -> {
        return p_191286_.group(Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_taller_dripstone").orElse(0.2F).forGetter((p_191294_) -> {
            return p_191294_.chanceOfTallerDripstone;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_directional_spread").orElse(0.7F).forGetter((p_191292_) -> {
            return p_191292_.chanceOfDirectionalSpread;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius2").orElse(0.5F).forGetter((p_191290_) -> {
            return p_191290_.chanceOfSpreadRadius2;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius3").orElse(0.5F).forGetter((p_191288_) -> {
            return p_191288_.chanceOfSpreadRadius3;
        })).apply(p_191286_, PointedSpectriumConfiguration::new);
    });
    public final float chanceOfTallerDripstone;
    public final float chanceOfDirectionalSpread;
    public final float chanceOfSpreadRadius2;
    public final float chanceOfSpreadRadius3;

    public PointedSpectriumConfiguration(float p_191281_, float p_191282_, float p_191283_, float p_191284_) {
        this.chanceOfTallerDripstone = p_191281_;
        this.chanceOfDirectionalSpread = p_191282_;
        this.chanceOfSpreadRadius2 = p_191283_;
        this.chanceOfSpreadRadius3 = p_191284_;
    }
}
