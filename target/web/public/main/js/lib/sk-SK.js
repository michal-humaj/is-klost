(function(factory) {
    // Module systems magic dance.
    /*global require,ko.validation,define,module*/
    if (typeof require === 'function' && typeof exports === 'object' && typeof module === 'object') {
        // CommonJS or Node
        module.exports = factory(require('../'));
    } else if (typeof define === 'function' && define['amd']) {
        // AMD anonymous module with hard-coded dependency on 'knockout.validation'
        define(['knockout.validation'], factory);
    } else {
        // <script> tag: use the global `ko.validation` object
        factory(ko.validation);
    }
}(function(kv) {
    if (!kv || typeof kv.defineLocale !== 'function') {
        throw new Error('Knockout-Validation is required, please ensure it is loaded before this localization file');
    }
    return kv.defineLocale('sk-SK', {
        required: 'Vyplňte prosím toto pole',
        min: 'Zadajte číslo väčšie alebo rovné {0}.',
        max: 'Zadejte číslo menší alebo rovné {0}.',
        minLength: 'Zadajte aspon {0} znaky.',
        maxLength: 'Vložte nejvíce {0} znaků.',
        pattern: 'Zkontrolujte formát pole.',
        step: 'Hodnota musí byť násobok {0}.',
        email: 'Neplatná e-mailová adresa.',
        date: 'Zadejte platné datum.',
        dateISO: 'Zadejte platné datum.',
        number: 'Zadajte číslo. Použite desatinnú bodku.',
        digit: 'Zadejte číslice.',
        phoneUS: 'Zadejte platné telefonní číslo.',
        equal: 'Hodnoty musí být stejné.',
        notEqual: 'Vyberte jinou hodnotu.',
        unique: 'Zkontrolujte, zda hodnota je jedinečná.'
    });
}));
