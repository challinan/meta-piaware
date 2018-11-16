SUMMARY = "Software to turn the RTL2832U into an SDR"
HOMEPAGE = "https://github.com/steve-m/librtlsdr"
SECTION = "network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRCREV = "f68bb2fa772ad94f58c59babd78353667570630b"
SRC_URI = "git://github.com/steve-m/librtlsdr.git \
           file://0001-Do-not-store-build-system-CFLAGS-in-the-pkgconfig-fi.patch \
"

DEPENDS = "libusb1"

inherit autotools pkgconfig lib_package

do_compile_prepend() {
    echo $PATH
    which pkg-config
}

EXTRA_OECONF = "--enable-driver-detach"

S = "${WORKDIR}/git"

do_install_append() {
        install -d ${D}${sysconfdir}/udev/rules.d
        install -m 0644 ${S}/rtl-sdr.rules ${D}${sysconfdir}/udev/rules.d
}

