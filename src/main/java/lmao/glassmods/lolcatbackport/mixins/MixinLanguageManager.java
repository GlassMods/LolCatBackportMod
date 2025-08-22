package lmao.glassmods.lolcatbackport.mixins;

import com.google.common.collect.Maps;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.LanguageManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(LanguageManager.class)
public abstract class MixinLanguageManager {

    @Shadow private Map<String, Language> languageMap = Maps.newHashMap();

    @Inject(method = "parseLanguageMetadata", at = @At("RETURN"))
    private void injectLolCatLanguage(List<IResourcePack> resourcesPacks, CallbackInfo ci) {
        Language lolCat = new Language("lol_koc", "Kingdum ov cats", "Lolcat", false);
        languageMap.put("lol_koc", lolCat);
    }
    
}
